package constant;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

	public static class login {
		// version
	    public static final long VERSION_NUM = 1L;
	    // title
	    public static final String TITLE = "Login system";
	        
	    // frame size
	    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    public static final int WIDTH = screenSize.width;
	    public static final int HEIGHT = screenSize.height;
	        
	    // login panel size
	    public static final int LOGIN_PANEL_WIDTH = WIDTH / 6;

	    // id field
	    public static final String IDFIELD = "ID : ";
	    public static final int ID_FIELD_LENGTH = 10;
	        
	    // pw field
	    public static final String PWFIELD = "PW : ";
	    public static final int PW_FIELD_LENGTH = 14;
	        
	    // login button
	    public static final String BT = "LOGIN";
	    
	    // image panel size
	    public static final int IMAGE_PANEL_WIDTH = WIDTH * 5 / 6;

	    // image path
	    public static final String IMAGE_PATH = "image/logo.png";
	    public static final String BACKIMAGE_PATH = "image/background.png";
	        
	    // success message
	    public static final String SUCCESS_MESSAGE = "success";
	        
	    // wrong password message
	    public static final String WRONG_PW_MESSAGE = "wrong pw";
	        
	    // none ID, PW message
	    public static final String NONE_ID_PW_MESSAGE = "none Id,pw.";
	}

	public class mainframe {
		//version
		final public static long VERSION_NUM=1L;	
		//title
		final public static String TITLE="수강신청";
		//size
		static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        public static int Width = screenSize.width * 2 / 3;
        public static int Height = screenSize.height * 2 / 3;
        public static int x = (screenSize.width - Width) / 2;
        public static int y = (screenSize.height - Height) / 2;
        final public static String LOGOUT="LOGOUT";
	}

	public class myinfo {
		//version
		final public static long VERSION_NUM=1L;	
		
		final public static String NAME="NAME : ";
		final public static String SCORE="SCORE : ";
		final public static String BLAMK="        ";
		final public static String SLASH="/";
	}
	
	public class sugang {
		//version
		final public static long VERSION_NUM=1L;	
		
		final public static String BASKET="BASKET";
		final public static String SHOWBASKET="SHOWBASKET";
		final public static String SELECT="SELECT";
		final public static String SHOWSELECT="SHOWSELECT";
		final public static String SEARCH="SEARCH";
		final public static String SHOWSEARCH="SHOWSEARCH";
		final public static String MY="MY";
		final public static String SHOWMY="SHOWMY";
	}

	public class indexTable {
		//header
		public enum EHeader {
            EID("id"),
            ETITLE("campus");
			
            private final String title;
            
            EHeader(String title) {
                this.title = title;}
            //methods
            public String getTitle() {
                return this.title; }
		}

	}

	public class indexpanel {
		final public static long VERSION_NUM=1L;
		final public static String ROOT="root";
	}

	public class indextable{
		final public static long VERSION_NUM=1L;
	}

	public class lecture {
		final public static long VERSION_NUM=1L;
		public enum ElectureHeader {
            EID("id"),
            ETITLE("name"),
			EPRONAME("proname"),
			ESCORE("Score"),
			ETIME("Time"), 
			EDAY("DAY"), 
			EPEOPLE("CURRENT"), 
			EWISHPEOPLE("WISH"), 
			EPEOPLELIMIT("LIMIT");
			
            private final String title;

            ElectureHeader(String title) {
                this.title = title;}
            
            public String getTitle() {
                return this.title;}
            
		}
	}

	public class controlbt{
		final public static long VERSION_NUM=1L;	
		final public static String MIRI="Basket";
		final public static String DELETEMIRI="Delete Basket";
		final public static String SINCHEONG="Enrollment";
		final public static String RIGHT="";
		public static final String DELETE = "Delete Enrollment";
	}

	public class select{
		final public static long VERSION_NUM=1L;
	}
	
	public class miri{
		final public static long VERSION_NUM=1L;
	}
	
	public class my{
		final public static long VERSION_NUM=1L;
	}

	public class search{
		final public static long VERSION_NUM=1L;
		final public static String GO="go";
		final public static String BASKET="BASKET";
	}

	public class dao{
		//etc
		final public static String error = "error";
		public static final String SUCESS = "SUCCESS";
		
		//string
		public static final String id="id";
		public static final String name="name";
		public static final String proname="proname";
		public static final String Score="Score";
		public static final String maxScore="maxScore";
		public static final String Time="Time";
		public static final String day="day";
		public static final String day2="day2";
		public static final String currentpeople="currentpeople";
		public static final String WISHPEOPLE = "wishpeople";
		public static final String peoplelimit="peoplelimit";
		public static final String course_id="course_id";
		public static final String COURSEDAY2 ="course_day1";
		public static final String COURSEDAY ="course_day";
		public static final String COURSETIME ="course_time";
		
		//login
		final public static String ISID = "SELECT * FROM members WHERE student_id = ?";
		final public static String ISPW = "SELECT * FROM members WHERE pw = ?";
		
		//get lecture info
		
		//link
		public static final String LINK_LECTURE = "SELECT id, name, proname, Score, Time, day, day2, wishpeople, currentpeople, peoplelimit  FROM all_lecture WHERE link = ?";
		
		//search
		public static final String SEARCH_LECTURE="SELECT id, name, proname, Score, Time, day, day2, wishpeople, currentpeople, peoplelimit FROM all_lecture WHERE id LIKE ? OR name LIKE ? OR proname LIKE ? OR Time LIKE ? OR day LIKE ? OR day2 LIKE ?";
		
		//id
		public static final String ID_LECTURE = "SELECT id, name, proname, Score, Time, day, day2, wishpeople, currentpeople, peoplelimit FROM all_lecture WHERE id = ?";
		public static final String LIMIT_LECTURE = "SELECT peoplelimit FROM all_lecture WHERE id = ?";
		public static final String CURRENT_LECTURE = "SELECT currentpeople FROM all_lecture WHERE id = ?";
		public static final String SCORE_LECTURE = "SELECT  Score FROM all_lecture WHERE id = ?";
		
		//show
		public static final String GETBASKET="SELECT course_id FROM basket WHERE student_id = ?";
		public static final String GETENROLL="SELECT course_id FROM enrollment WHERE student_id = ?";
		
		//get
		public static final String BLANK= " ";
		public static final String FILETYPE=".txt";
		public static final String LOCATION="data/";
		public static final String DIVIDE ="%";
		public static final String BAR ="-";
		public static final String BASKET = "basket";
		
		//basket
		public static final String ISBASKET = "SELECT 1 FROM basket WHERE student_id = ? AND course_id = ?";
		public static final String INSERT_BASKET= "INSERT INTO basket (student_id, course_id) VALUES (?, ?)";
		public static final String DELETE_BASKET="DELETE FROM basket WHERE student_id = ? AND course_id = ?"; 
		public static final String WISH_DOWN = "UPDATE all_lecture SET wishpeople = wishpeople - 1 WHERE id = ?";
		public static final String WISH_UP = "UPDATE all_lecture SET wishpeople = wishpeople + 1 WHERE id = ?";
		
		//enrollment / delete
		public static final String ISENROLLMENT="SELECT 1 FROM enrollment WHERE student_id = ? AND course_id = ?" ;
		public static final String CURRENTUP="UPDATE all_lecture SET currentpeople = currentpeople + 1 WHERE id = ?";
		public static final String CURRENTDOWN = "UPDATE all_lecture SET currentpeople = currentpeople - 1 WHERE id = ?";
		public static final String SCOREUP ="UPDATE members SET score = ? WHERE student_id = ?";
		public static final String SCOREDOWN = "UPDATE members SET score = CASE WHEN score - ? >= 0 THEN score - ? ELSE 0 END WHERE student_id = ?";		
		public static final String INSERTENROLL = "INSERT INTO enrollment (student_id, course_id, course_time, course_day, course_day1) VALUES (?, ?, ?, ?, ?)";
		public static final String DELETEENROLL = "DELETE FROM enrollment WHERE student_id = ? AND course_id = ?";
		public static final String getScore = "SELECT score FROM members WHERE student_id = ?";
		public static final String getScorelimit = "SELECT maxScore FROM members WHERE student_id = ?";
		public static final String getCourseDay = "SELECT day FROM all_lecture WHERE id = ?";
		public static final String getCourseDay2 = "SELECT day2 FROM all_lecture WHERE id = ?";
		public static final String getCourseTime="SELECT time FROM all_lecture WHERE id = ?";
		public static final String GETEXISTCOURSE = "SELECT course_time, course_day, course_day1 FROM enrollment WHERE student_id = ?";
		
		//myinfo
		public static final String myinfoquery="SELECT name, Score, maxScore FROM members WHERE student_id = ?";

		//alarm
		public static final String already="이미 장바구니에 존재하는 강좌입니다.";
		public static final String BASKETCOMPLETE = "장바구니 등록이 완료되었습니다.";
		public static final String DELBASKETCOMPLETE = "미리담기에서 강좌가 삭제되었습니다.";
		public static final String NOTEXIST = "등록되지 않은 강좌입니다.";
		public static final String PEOPLEOVER = "인원 초과입니다.";
		public static final String TIMEOVER = "강좌의 시간대 또는 요일이 겹치는 강좌가 이미 등록되어 있습니다.";
		public static final String SCOREOVER = "학점을 초과하여 등록할 수 없습니다.";
		public static final String ENROLLCOMPLETE = "강좌 등록이 완료되었습니다.";
		public static final Object DELETECOMPLETE = "강좌 삭제가 완료되었습니다.";
		public static final String ALREADYENROLL = "\"이미 등록되었습니다.\"";
	}

	public class control{
		public static final String ENROLLMENT="Enrollment";
		public static final String BASKET="basket";
	}

	public class database{
		public static final String DRIVER_PATH="com.mysql.cj.jdbc.Driver";
		public static final String DRIVER_URL="jdbc:mysql://localhost:3306/student";
		public static final String DB_PASSWORD="0000";
		public static final String DB_USER_ID="root";
	}
}

