package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import Constant.constant.dao;

public class DAO {
    //attributes  
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    //constructors
    public DAO() {}

    //initialize
    public void initialize() {}

    //methods 
    //connect
    public void Connect() {
        try {Class.forName(dao.DRIVER);
            con = DriverManager.getConnection(dao.JDBC_URL, dao.USERNAME, dao.PASSWORD);
        } catch (Exception e) {
            System.out.println(dao.error + e.getMessage()); }
    }//close
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //get	
    
    public Vector<Model> getLectureByLink(String link) {
    	return getCourseInfo(dao.LINK_LECTURE,link);
    }
    public Vector<Model> getLectureById(String id) {
        return getCourseInfo(dao.ID_LECTURE, id);
    }
    public Vector<Model> getLectureKeyword(String keyword) {
        String searchKeyword = dao.DIVIDE + keyword + dao.DIVIDE;
        return getCourseInfo(dao.SEARCH_LECTURE, searchKeyword, searchKeyword, searchKeyword, searchKeyword, searchKeyword,searchKeyword);
    }
    public Vector<Model> getCourseInfo(String query, Object... params) {
        Vector<Model> courseList = new Vector<>();
        try {
            Connect();
            rs = executeQuery(query, params);
            while (rs.next()) {
                Model course = new Model();
                course.setId(rs.getString(dao.id));
                course.setName(rs.getString(dao.name));
                course.setProname(rs.getString(dao.proname));
                course.setScore(rs.getString(dao.Score));
                course.setTime(rs.getString(dao.Time));
                course.setday(rs.getString(dao.day) + dao.BLANK + rs.getString(dao.day2));
                course.setwhishpeople(rs.getString(dao.WISHPEOPLE));
                course.setPeople(rs.getString(dao.currentpeople));
                course.setPeoplelimit(rs.getString(dao.peoplelimit));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, dao.error + e.getMessage(), dao.error, JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
        return courseList;
    }
    public Vector<Model> getList(String link) {
        Vector<Model> List = new Vector<Model>();
        try {
            File file = new File(dao.LOCATION + link + dao.FILETYPE);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] wordList = line.split(dao.BLANK);
                if (wordList.length == 3) {
                    Model mLecture = new Model();
                    mLecture.setId(wordList[0]);
                    mLecture.setName(wordList[1]);
                    mLecture.setLink(wordList[2]);
                    List.add(mLecture);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return List;
    }
    //show
    public Vector<Model> show(Integer studentId,String table) {
        Vector<Model> courseList = new Vector<>();

        try {
            Connect();
            if(table.equals(dao.BASKET)) {
            rs = executeQuery(dao.GETBASKET, studentId);}
            else {
            rs = executeQuery(dao.GETENROLL, studentId);}
            Vector<String> courseIds = new Vector<>();
            while (rs.next()) {
                courseIds.add(rs.getString(dao.course_id));
            }
            closeResources();
            for (String courseId : courseIds) {
                courseList.addAll(getLectureById(courseId));}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }return courseList;
    }


    
    //enrollment methods
    public void ToBasket(Integer integer, int strid) {      
        try {
        	 Connect();
             //if exists
             if (executeBoolean(dao.ISBASKET, integer, strid)) {
             	//raise error
                 JOptionPane.showMessageDialog(null, dao.already, dao.error, JOptionPane.ERROR_MESSAGE);
                 return;}
             else {
            	//insert basket
            	executeUpdate(dao.INSERT_BASKET, integer, strid);
            	//wish people +1
                executeUpdate(dao.WISH_UP, strid);
                JOptionPane.showMessageDialog(null, dao.BASKETCOMPLETE, dao.SUCESS, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, dao.already, dao.error, JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }

    //delete lecture from basket
    public void DELBasket(Integer student, int courseid) {
        try {
            Connect();
            //is it basket
            if (executeBoolean(dao.ISBASKET,student,courseid)) {
            	
                // delete from basket
                executeUpdate(dao.DELETE_BASKET,student,courseid);
                // wish people-1
                executeUpdate(dao.WISH_DOWN,courseid);
                JOptionPane.showMessageDialog(null, dao.DELBASKETCOMPLETE, dao.SUCESS, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, dao.NOTEXIST, dao.error, JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,dao.NOTEXIST, dao.error, JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }
	
	//enrollment lecture
    public void ToEnrollment(Integer student, int courseid) {
        try {
            Connect();
            //if exists
            if (executeBoolean(dao.ISENROLLMENT, student, courseid)) {
            	//raise error
                JOptionPane.showMessageDialog(null, dao.ALREADYENROLL, dao.error, JOptionPane.ERROR_MESSAGE);
                return;}
            //lectures limit people check
            int limit = executeTOInt(dao.LIMIT_LECTURE, courseid);
            int current = executeTOInt(dao.CURRENT_LECTURE, courseid);
            if (limit <= current) {
                JOptionPane.showMessageDialog(null, dao.PEOPLEOVER,dao.error, JOptionPane.ERROR_MESSAGE);
                return;
            }
            //check course day,time
            String courseTime = executeToString(dao.getCourseTime, courseid);
            String courseDay = executeToString(dao.getCourseDay, courseid);
            String courseDay2 = executeToString(dao.getCourseDay2, courseid);
            //check with exist course
            if (checkwithexist(student, courseTime, courseDay, courseDay2)) {
                JOptionPane.showMessageDialog(null, dao.TIMEOVER, dao.error, JOptionPane.ERROR_MESSAGE);
                return;}
            //check your score limit
            int courseScore = executeTOInt(dao.SCORE_LECTURE, courseid);
            int studentScore = executeTOInt(dao.getScore, student);
            int scoreLimit = executeTOInt(dao.getScorelimit, student);
            if (studentScore + courseScore > scoreLimit) {
                JOptionPane.showMessageDialog(null, dao.SCOREOVER, dao.error, JOptionPane.ERROR_MESSAGE);
                return;}
            //score up
            executeUpdate(dao.SCOREUP, studentScore + courseScore, student);
            // register to Enrollment table
            executeUpdate(dao.INSERTENROLL, student, courseid, courseTime, courseDay, courseDay2);
            
            // Increase  current people + 1
            executeUpdate(dao.CURRENTUP, courseid);
            JOptionPane.showMessageDialog(null, dao.ENROLLCOMPLETE, dao.SUCESS, JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, dao.error + e.getMessage(), dao.error, JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }
    //check time and days
    private boolean checkwithexist(Integer student, String courseTime, String courseDay, String courseDay2) throws SQLException {
        ResultSet existingCoursesRs = executeQuery(dao.GETEXISTCOURSE, student);
        
        while (existingCoursesRs.next()) {
            String existingCourseTime = existingCoursesRs.getString(dao.COURSETIME);
            String existingCourseDay = existingCoursesRs.getString(dao.COURSEDAY);
            String existingCourseDay2 = existingCoursesRs.getString(dao.COURSEDAY2);
            
            if (checkDay(existingCourseDay, existingCourseDay2, courseDay, courseDay2) && checkTime(courseTime, existingCourseTime)) {
                return true;}
        }
        return false;
    }
    public boolean checkDay(String day1, String day2, String day3, String day4) {
        
        boolean Match1 = (day1 != null && day1.equals(day3));
        boolean Match2 = (day1 != null && day1.equals(day4));
        boolean Match3 = (day2 != null && day2.equals(day3));
        boolean Match4 = (day2 != null && day2.equals(day4));
        
        return Match1 || Match2 || Match3 || Match4;
    }
    public boolean checkTime(String time1, String time2) {
        String[] parts1 = time1.split(dao.BAR);
        String[] parts2 = time2.split(dao.BAR);
        int startTime1 = Integer.parseInt(parts1[0]);
        int endTime1 = Integer.parseInt(parts1[1]);
        int startTime2 = Integer.parseInt(parts2[0]);
        int endTime2 = Integer.parseInt(parts2[1]);

        if (startTime1 >= endTime2 || endTime1 <= startTime2) {
            return false;
        } else {
            return true;}
    }
    

    //delete enrolled lecture
    public void Delete(int studentId, int courseId) {
        try {
            Connect();
            
            // enrollment 테이블에서 해당 학생과 강좌 ID에 해당하는 항목 조회
            if (executeBoolean(dao.ISENROLLMENT, studentId, courseId)) {
                // enrollment에서 해당 항목을 찾은 경우
                // 해당 강좌의 Score에서 강좌 score 빼기
                int courseScore = executeTOInt(dao.SCORE_LECTURE, courseId);
                executeUpdate(dao.SCOREDOWN, courseScore, courseScore,studentId);
                
                // delete from enrollment
                int result = executeUpdate(dao.DELETEENROLL, studentId, courseId);
                if (result > 0) {
                    // enrollment에서 항목이 삭제된 경우 currentpeople -1
                    executeUpdate(dao.CURRENTDOWN, courseId);
                    JOptionPane.showMessageDialog(null, dao.DELETECOMPLETE, dao.SUCESS, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, dao.NOTEXIST, dao.error, JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // enrollment에서 해당 항목을 찾지 못한 경우
                JOptionPane.showMessageDialog(null, dao.NOTEXIST, dao.error, JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, dao.error + e.getMessage(), dao.error, JOptionPane.ERROR_MESSAGE);
        } finally {
            closeResources();
        }
    }

 
    //login methods
	public boolean IsId(int id) {
        return isRight(dao.ISID, id);
    }

    public boolean IsPw(String pw) {
        return isRight(dao.ISPW, pw);
    }

    public boolean isRight(String sql, Object obj) {
    	boolean result = false;
        try {
            Connect(); 	
            result=executeBoolean(sql,obj);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources();
        }
        return result;
    }
    //score & name 
	public Vector<Model> myinfo(int userId) {
		Vector<Model> list = new Vector<Model>();
		try {
            Connect();
            ps = con.prepareStatement(dao.myinfoquery);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
            	Model userInfo = new Model();
                userInfo.setName(rs.getString(dao.name));
                userInfo.setstScore(rs.getInt(dao.Score));
                userInfo.setScoreLimit(rs.getInt(dao.maxScore));
                list.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }

    
	
	//query methods
	private void prepareStatement(String query, Object... params) throws SQLException {
        ps = con.prepareStatement(query);
        int index = 1;
        for (Object param : params) {
            if (param instanceof Integer) {
                ps.setInt(index++, (Integer) param);
            } else if (param instanceof String) {
                ps.setString(index++, (String) param);
            }
        }
    }

    private int executeUpdate(String query, Object... params) throws SQLException {
        prepareStatement(query, params);
        for (int i = 0; i < params.length; i++) {
            if (params[i] == null) {
                ps.setNull(i + 1, Types.VARCHAR); 
            } else if (params[i] instanceof Integer) {
                ps.setInt(i + 1, (Integer) params[i]);
            } else if (params[i] instanceof String) {
                ps.setString(i + 1, (String) params[i]);
            }
        }
        return ps.executeUpdate();
    }
    private ResultSet executeQuery(String query, Object... params) throws SQLException {
        prepareStatement(query, params);
        return ps.executeQuery();
    }

    private int executeTOInt(String query, Object... params) throws SQLException {
        ResultSet resultSet = executeQuery(query, params);
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            return -1;
        }
    }private String executeToString(String query, Object... params)throws SQLException {
        ResultSet resultSet = executeQuery(query, params);
        try {
            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private boolean executeBoolean(String query, Object... params) throws SQLException {
        ResultSet resultSet = executeQuery(query, params);
        return resultSet.next();
    }

}
