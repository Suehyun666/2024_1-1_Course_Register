package dao;

import model.MDepartment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends BaseDAO {
    private static final String SELECT_BY_COLLEGE = "SELECT dept_id, college_id, name FROM department WHERE college_id = ?";

    public List<MDepartment> findByCollegeId(int collegeId) {
        List<MDepartment> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SELECT_BY_COLLEGE, collegeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                MDepartment dept = new MDepartment(
                    rs.getInt("dept_id"),
                    rs.getInt("college_id"),
                    rs.getString("name")
                );
                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }
}
