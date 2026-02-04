package dao;

import model.MCampus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampusDAO extends BaseDAO {
    private static final String SELECT_ALL = "SELECT campus_id, name FROM campus";
    private static final String SELECT_BY_ID = "SELECT campus_id, name FROM campus WHERE campus_id = ?";

    public List<MCampus> findAll() {
        List<MCampus> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                MCampus campus = new MCampus(
                    rs.getInt("campus_id"),
                    rs.getString("name")
                );
                list.add(campus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }
}
