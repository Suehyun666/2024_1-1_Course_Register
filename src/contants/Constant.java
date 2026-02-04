package contants;

public class Constant {
	
	public class mainframe {
		// version
		final public static long VERSION_NUM=1L;	//숫자가 8바이트까지다.
		final public static String TITLE="수강신청";
		final public static int x=300;
		final public static int y=300;
		final public static int WIDTH=300;
		final public static int TT=300;	
	}
	
	public class indexTable {		
		public enum EHeader {
            EID("아이디"),
            ETITLE("캠퍼스");
            
			private final String title;
            
			EHeader(String title) {
                this.title = title;
            }
            public String getTitle() {
                return this.title;
            }
		}
	}
	
	public class indexpanel {
		final public static String ROOT="root";
	}
	
	public class lecture {
		public enum ElectureHeader {
            EID("id"),
            ETITLE("name"),
			EPRONAME("proname"),
			ESCORE("Score"),
			ETIME("Time");
			
            private final String title;

            ElectureHeader(String title) {
                this.title = title;
            }

            public String getTitle() {
                return this.title;
            }
		}
	}
}

