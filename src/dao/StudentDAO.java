package dao;

import model.MStudent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO extends BaseDAO {
    private static final String SELECT_BY_ID_AND_PW = "SELECT student_id, password, name, dept_id, max_credits FROM student WHERE student_id = ? AND password = ?";

    public MStudent login(int studentId, String hashedPassword) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SELECT_BY_ID_AND_PW, studentId, hashedPassword);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new MStudent(
                    rs.getInt("student_id"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getInt("dept_id"),
                    rs.getInt("max_credits")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
    }
}
