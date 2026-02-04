package dao;

import database.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO {
    protected DatabaseManager dbManager = DatabaseManager.getInstance();

    protected Connection getConnection() {
        return dbManager.getConnection();
    }

    protected void releaseConnection(Connection conn) {
        dbManager.releaseConnection(conn);
    }

    protected void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        releaseConnection(conn);
    }

    protected PreparedStatement prepareStatement(Connection conn, String sql, Object... params) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof Integer) {
                ps.setInt(i + 1, (Integer) params[i]);
            } else if (params[i] instanceof String) {
                ps.setString(i + 1, (String) params[i]);
            } else if (params[i] instanceof Long) {
                ps.setLong(i + 1, (Long) params[i]);
            } else {
                ps.setObject(i + 1, params[i]);
            }
        }
        return ps;
    }

    protected int executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, sql, params);
            int result = ps.executeUpdate();
            conn.commit();
            return result;
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            closeResources(null, ps, conn);
        }
    }

    protected boolean exists(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, sql, params);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
    }

    protected int queryForInt(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, sql, params);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
    }
}
