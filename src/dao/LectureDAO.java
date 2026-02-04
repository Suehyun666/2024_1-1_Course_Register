package dao;

import model.MLecture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class LectureDAO extends BaseDAO {
    private static final String SELECT_ALL_COLUMNS_WITH_COUNTS =
        "l.lecture_id, l.dept_id, l.title, l.professor, l.credits, l.capacity, " +
        "l.day1, l.start_time1, l.end_time1, l.day2, l.start_time2, l.end_time2, " +
        "(SELECT COUNT(*) FROM enrollment e WHERE e.lecture_id = l.lecture_id) as enrolled_count, " +
        "(SELECT COUNT(*) FROM basket b WHERE b.lecture_id = l.lecture_id) as basket_count";

    private static final String SELECT_BY_ID = "SELECT " + SELECT_ALL_COLUMNS_WITH_COUNTS + " FROM lecture l WHERE l.lecture_id = ?";
    private static final String SELECT_BY_DEPT = "SELECT " + SELECT_ALL_COLUMNS_WITH_COUNTS + " FROM lecture l WHERE l.dept_id = ?";
    private static final String SEARCH = "SELECT " + SELECT_ALL_COLUMNS_WITH_COUNTS + " FROM lecture l WHERE l.title LIKE ? OR l.professor LIKE ? OR CAST(l.lecture_id AS CHAR) LIKE ?";
    private static final String COUNT_ENROLLED = "SELECT COUNT(*) FROM enrollment WHERE lecture_id = ?";
    private static final String COUNT_BASKET = "SELECT COUNT(*) FROM basket WHERE lecture_id = ?";

    private MLecture mapRow(ResultSet rs) throws SQLException {
        MLecture lecture = new MLecture(
            rs.getInt("lecture_id"),
            rs.getInt("dept_id"),
            rs.getString("title"),
            rs.getString("professor"),
            rs.getInt("credits"),
            rs.getInt("capacity")
        );
        lecture.setEnrolledCount(rs.getInt("enrolled_count"));
        lecture.setBasketCount(rs.getInt("basket_count"));

        String day1 = rs.getString("day1");
        Time start1 = rs.getTime("start_time1");
        Time end1 = rs.getTime("end_time1");
        if (day1 != null && start1 != null && end1 != null) {
            lecture.addSchedule(day1, start1.toLocalTime(), end1.toLocalTime());
        }

        String day2 = rs.getString("day2");
        Time start2 = rs.getTime("start_time2");
        Time end2 = rs.getTime("end_time2");
        if (day2 != null && start2 != null && end2 != null) {
            lecture.addSchedule(day2, start2.toLocalTime(), end2.toLocalTime());
        }

        return lecture;
    }

    public MLecture findById(int lectureId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SELECT_BY_ID, lectureId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
    }

    public List<MLecture> findByDeptId(int deptId) {
        List<MLecture> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SELECT_BY_DEPT, deptId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }

    public List<MLecture> search(String keyword) {
        List<MLecture> list = new ArrayList<>();
        String pattern = "%" + keyword + "%";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, SEARCH, pattern, pattern, pattern);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }

    public int getEnrolledCount(int lectureId) {
        return queryForInt(COUNT_ENROLLED, lectureId);
    }

    public int getBasketCount(int lectureId) {
        return queryForInt(COUNT_BASKET, lectureId);
    }
}
