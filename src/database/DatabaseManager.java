package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DatabaseManager {
    private static DatabaseManager instance;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/course_register";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";
    private static final int POOL_SIZE = 10;

    private BlockingQueue<Connection> pool;

    private DatabaseManager() {
        try {
            Class.forName(DRIVER);
            pool = new ArrayBlockingQueue<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                pool.add(createConnection());
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private Connection createConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        conn.setAutoCommit(false);
        return conn;
    }

    public Connection getConnection() {
        try {
            Connection conn = pool.take();
            if (conn.isClosed()) {
                conn = createConnection();
            }
            return conn;
        } catch (InterruptedException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.rollback();
                    pool.offer(conn);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        for (Connection conn : pool) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
