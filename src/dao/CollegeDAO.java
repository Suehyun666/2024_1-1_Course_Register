package dao;

import model.MCollege;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollegeDAO extends BaseDAO {
    private static final String SELECT_BY_CAMPUS = "SELECT college_id, campus_id, name FROM college WHERE campus_id = ?";

    public List<MCollege> findByCampusId(int campusId) {
        List<MCollege> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SELECT_BY_CAMPUS, campusId);
            rs = ps.executeQuery();
            while (rs.next()) {
                MCollege college = new MCollege(
                    rs.getInt("college_id"),
                    rs.getInt("campus_id"),
                    rs.getString("name")
                );
                list.add(college);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }
}
