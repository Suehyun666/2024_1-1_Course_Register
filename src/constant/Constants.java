package constant;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Constants {

	public static class login {
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
	    public static final String IMAGE_PATH = "resources/image/logo.png";
	    public static final String BACKIMAGE_PATH = "resources/image/background.png";
	}

	public class mainframe {
		//title
		final public static String TITLE="Course Registration";
		//size
		static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        public static int Width = screenSize.width * 2 / 3;
        public static int Height = screenSize.height * 2 / 3;
        public static int x = (screenSize.width - Width) / 2;
        public static int y = (screenSize.height - Height) / 2;
        final public static String LOGOUT="LOGOUT";
	}

	public class myinfo {
		final public static String NAME="NAME : ";
		final public static String SCORE="CREDITS : ";
		final public static String BLAMK="        ";
		final public static String SLASH="/";
	}
	
	public class sugang {
		final public static String BASKET="BASKET";
		final public static String SHOWBASKET="SHOW BASKET";
		final public static String SELECT="Select (Course List)";
		final public static String SHOWSELECT="SHOW SELECT";
		final public static String SEARCH="SEARCH";
		final public static String SHOWSEARCH="SHOW SEARCH";
		final public static String MY="Enrolled";
		final public static String SHOWMY="SHOW ENROLLED";
	}

	public class indexTable {
		//header
		public enum EHeader {
            EID("ID"),
            ETITLE("Name");
			
            private final String title;
            
            EHeader(String title) {
                this.title = title;}
            //methods
            public String getTitle() {
                return this.title; }
		}

	}

	public class indexpanel {
		final public static String ROOT="root";
	}

	public class lecture {
		public enum ElectureHeader {
            EID("ID"),
            ETITLE("Lecture Name"),
			EPRONAME("Professor"),
			ESCORE("Credits"),
			ETIME("Time"), 
			EDAY("Day"), 
			EPEOPLE("Current"), 
			EWISHPEOPLE("Wish"), 
			EPEOPLELIMIT("Limit");
			
            private final String title;

            ElectureHeader(String title) {
                this.title = title;}
            
            public String getTitle() {
                return this.title;}
            
		}
	}

	public class controlbt{
		final public static String MIRI="Add to Basket";
		final public static String DELETEMIRI="Remove from Basket";
		final public static String SINCHEONG="Enroll";
		public static final String DELETE = "Drop Course";
	}

    public static class Message {
        public static final String ENROLL_SUCCESS = "Enrollment Successful!";
        public static final String ENROLL_CANCEL_SUCCESS = "Enrollment Cancelled!";
        public static final String BASKET_ADD_SUCCESS = "Added to Basket!";
        public static final String BASKET_REMOVE_SUCCESS = "Removed from Basket!";
        public static final String LOGIN_SUCCESS = "Login Successful!";
    }

    public static class ErrorMessage {
        public static final String LOGIN_REQUIRED = "Login Required.";
        public static final String ALREADY_ENROLLED = "Already Enrolled.";
        public static final String LECTURE_NOT_FOUND = "Lecture Not Found.";
        public static final String CAPACITY_EXCEEDED = "Capacity Exceeded.";
        public static final String CREDITS_EXCEEDED = "Credit Limit Exceeded.";
        public static final String TIME_CONFLICT = "Time Conflict.";
        public static final String NOT_ENROLLED = "Not Enrolled.";
        public static final String ALREADY_IN_BASKET = "Already in Basket.";
        public static final String NOT_IN_BASKET = "Not in Basket.";
        public static final String INVALID_ID_PW = "Invalid ID or Password.";
        public static final String ID_MUST_BE_NUMBER = "Please enter ID as a number.";
    }

    public static class DialogTitle {
        public static final String SUCCESS = "Success";
        public static final String ERROR = "Error";
    }

    public static class Directory {
        public static final String ROOT = "root";
        public static final String CAMPUS_PREFIX = "campus:";
        public static final String COLLEGE_PREFIX = "college:";
        public static final String DEPT_PREFIX = "dept:";
    }
}

