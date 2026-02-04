package view;

import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import constant.Constants.lecture.ElectureHeader;
import controller.BasketController;
import controller.EnrollmentController;
import controller.LectureController;
import model.MLecture;
import model.MLecture.Schedule;

public class VlectureScrollPane extends JScrollPane implements IindexTable {
	private static final long serialVersionUID = 1L;
	
	//components
	private JTable table;
	private DefaultTableModel model;
	private LectureController lectureController;
    private EnrollmentController enrollmentController;
    private BasketController basketController;
	private String link,keyword;

	//constructor
	public VlectureScrollPane() {
		this.table = new JTable();
		this.setViewportView(this.table);
		String[] headers = {ElectureHeader.EID.getTitle(),
				ElectureHeader.ETITLE.getTitle(),
            	ElectureHeader.EPRONAME.getTitle(),
            	ElectureHeader.ESCORE.getTitle(),
            	ElectureHeader.EDAY.getTitle(),
            	ElectureHeader.ETIME.getTitle(),
            	ElectureHeader.EWISHPEOPLE.getTitle(),
            	ElectureHeader.EPEOPLE.getTitle(),
            	ElectureHeader.EPEOPLELIMIT.getTitle()
		};
		this.model = new DefaultTableModel(null,headers);
		this.lectureController = new LectureController();
        this.enrollmentController = new EnrollmentController();
        this.basketController = new BasketController();
	
		//associate
    	this.table.setModel(model);
	}

	//methods
	public void show(String link) {
		this.link=link;
		this.keyword=null;
    	take(lectureController.getLectures(link));	
    }

	public void showBasket() {take(basketController.getBasketLectures());}

	public void showMy() {take(enrollmentController.getEnrolledLectures());}

	public void showSearch(String keyword) {
		this.keyword=keyword;
		this.link=null;
		take(lectureController.searchLectures(keyword));
	}

	public void take(List<MLecture> lectureList) {
	    this.model.setRowCount(0);
	    String[] columns = new String[9];
	    for (MLecture lecture : lectureList) {
	        columns[0] = String.valueOf(lecture.getLectureId());
	        columns[1] = lecture.getTitle();
	        columns[2] = lecture.getProfessor();
	        columns[3] = String.valueOf(lecture.getCredits());
            
            // Format Schedule
            StringBuilder days = new StringBuilder();
            StringBuilder times = new StringBuilder();
            for (Schedule s : lecture.getSchedules()) {
                if (days.length() > 0) days.append(", ");
                days.append(s.getDayOfWeek());
                
                if (times.length() > 0) times.append(", ");
                times.append(s.getStartTime().toString()).append("-").append(s.getEndTime().toString());
            }

	        columns[4] = days.toString();
	        columns[5] = times.toString();
	        columns[6] = String.valueOf(lecture.getBasketCount());
	        columns[7] = String.valueOf(lecture.getEnrolledCount());
	        columns[8] = String.valueOf(lecture.getCapacity());
	        this.model.addRow(columns);
	    }
	}

	//update
	public void update() {
		if (link!=null) {
			show(link);}
		if (keyword!=null) {
			showSearch(keyword);
		}
	}

	//clear
	public void clear() {
		this.model.setRowCount(0);
	}
	
	//select(control button) method
	public int getcourseid() {
		int selectedRow = this.table.getSelectedRow();
	    if (selectedRow != -1) {
	        String idString = this.table.getValueAt(selectedRow, 0).toString();
	        return Integer.parseInt(idString);}
	    else {
			return -1;
		}
	}

	//initialize
	public void initialize() {}
}	