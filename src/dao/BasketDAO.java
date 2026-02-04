package dao;

import model.MBasket;
import model.MLecture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDAO extends BaseDAO {
    private static final String INSERT = "INSERT INTO basket (student_id, lecture_id) VALUES (?, ?)";
    private static final String DELETE = "DELETE FROM basket WHERE student_id = ? AND lecture_id = ?";
    private static final String EXISTS = "SELECT 1 FROM basket WHERE student_id = ? AND lecture_id = ?";
    private static final String GET_BASKET_LECTURES =
        "SELECT l.lecture_id, l.dept_id, l.title, l.professor, l.credits, l.capacity, " +
        "l.day1, l.start_time1, l.end_time1, l.day2, l.start_time2, l.end_time2 " +
        "FROM basket b " +
        "INNER JOIN lecture l ON b.lecture_id = l.lecture_id " +
        "WHERE b.student_id = ?";

    public boolean exists(int studentId, int lectureId) {
        return exists(EXISTS, studentId, lectureId);
    }

    public int insert(int studentId, int lectureId) {
        return executeUpdate(INSERT, studentId, lectureId);
    }

    public int delete(int studentId, int lectureId) {
        return executeUpdate(DELETE, studentId, lectureId);
    }

    public List<MLecture> getStudentBasketLectures(int studentId) {
        List<MLecture> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = prepareStatement(conn, GET_BASKET_LECTURES, studentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                MLecture lecture = new MLecture(
                    rs.getInt("lecture_id"),
                    rs.getInt("dept_id"),
                    rs.getString("title"),
                    rs.getString("professor"),
                    rs.getInt("credits"),
                    rs.getInt("capacity")
                );

                String day1 = rs.getString("day1");
                java.sql.Time start1 = rs.getTime("start_time1");
                java.sql.Time end1 = rs.getTime("end_time1");
                if (day1 != null && start1 != null && end1 != null) {
                    lecture.addSchedule(day1, start1.toLocalTime(), end1.toLocalTime());
                }

                String day2 = rs.getString("day2");
                java.sql.Time start2 = rs.getTime("start_time2");
                java.sql.Time end2 = rs.getTime("end_time2");
                if (day2 != null && start2 != null && end2 != null) {
                    lecture.addSchedule(day2, start2.toLocalTime(), end2.toLocalTime());
                }

                list.add(lecture);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, ps, conn);
        }
        return list;
    }
}
