package view;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constant.Constants.lecture;
import constant.Constants.lecture.ElectureHeader;
import control.Control;
import model.Model;




public class VlectureScrollPane extends JScrollPane implements IindexTable {
	//attributes
	private static final long serialVersionUID = lecture.VERSION_NUM;
	//components
	private JTable table;
	private DefaultTableModel model;
	private Vector<Model> mLectureList;
	private Control control;
	private String link,keyword;
	
	//association
	private IindexTable next;
	public void setNext(IindexTable next) {this.next = next;}

	//constructor
	public VlectureScrollPane() {
	//components
		
	//table
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
            ElectureHeader.EPEOPLELIMIT.getTitle()};
	//model
	this.model = new DefaultTableModel(null,headers);
	this.mLectureList=new Vector<Model>();
	this.control = new Control();
	
	//associate
    this.table.setModel(model);
	}
	//methods
		//show
	public void show(String link) {
		this.link=link;
		this.keyword=null;
    	take(control.getLecture(link));	
    	//miri
	}public void showBasket() {
		take(control.getBasket());
		//my
	}public void showMy() {
		take(control.getMyEnrollment());
		//search
	}public void showSearch(String keyword) {
		this.keyword=keyword;
		this.link=null;
		take(control.getsearch(keyword));
	}
	//add lecture
	public void take(Vector<Model> lectureList) {
	    this.model.setRowCount(0);
	    String[] columns = new String[9];
	    for (Model mLecture : lectureList) {
	        columns[0] = mLecture.getId();
	        columns[1] = mLecture.getName();
	        columns[2] = mLecture.getProname();
	        columns[3] = mLecture.getScore();
	        columns[4] = mLecture.getday();
	        columns[5] = mLecture.getTime();
	        columns[6] = mLecture.getwishpeople();
	        columns[7] = mLecture.getPeople();
	        columns[8] = mLecture.getPeoplelimit();
	        this.model.addRow(columns);
	    }
	}
	//refresh
	public void update() {
		if (link!=null) {
			show(link);}
		if (keyword!=null) {
			showSearch(keyword);
		}
	}//clear
	public void clear() {
		this.model.setRowCount(0);}
	
	
	//select(control button) method
	public int getcourseid() {
		int selectedRow = this.table.getSelectedRow();
	    if (selectedRow != -1) {
	        String idString = this.table.getValueAt(selectedRow, 0).toString();
	        return Integer.parseInt(idString);}
	    else {return -1; }}
	

	
	//initialize
	public void initialize() {}
	
}	