package view;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import contants.Constant.lecture.ElectureHeader;
import control.Control;
import model.Model;

public class VlectureScrollPane extends JScrollPane implements IindexTable {
	private static final long serialVersionUID = 1L;
	
	//components
	private JTable table;
	private DefaultTableModel model;
	private Vector<Model> mLectureList;
	
	// constructors
	public VlectureScrollPane() {
		// attributes
		this.table = new JTable();
		this.setViewportView(this.table);
	
		String[] headers = {
            ElectureHeader.EID.getTitle(),
            ElectureHeader.ETITLE.getTitle(),
            ElectureHeader.EPRONAME.getTitle(),
            ElectureHeader.ESCORE.getTitle(),
            ElectureHeader.ETIME.getTitle()
            };
		this.model = new DefaultTableModel(null,headers);
		
		//associate
		this.table.setModel(model);
		this.mLectureList=new Vector<Model>();
	}
	
	// initialize
	public void initialize() {}
	
	//methods
	public void show(String link) {
		Control clecture=new Control();
    	mLectureList = clecture.getList(link);
    	this.model.setRowCount(0);
    	for (Model mLecture : mLectureList) {
    		take(mLecture);
    	}		
	}
	
	public void take(Model mLecture) {
        String[] columns = new String[5];
        columns[0] = mLecture.getId();
        columns[1] = mLecture.getName();
        columns[2] = mLecture.getName1();
        columns[3] = mLecture.getScore();
        columns[4] = mLecture.getTime();
        this.model.addRow(columns);
    }
	
	//setters and getters
	public Vector<Model> getSelectedList() {
		int[]Index=this.table.getSelectedRows();
		Vector<Model> List=new Vector<Model>();
		for (int index: Index) {
			List.add(mLectureList.get(index));
		}return List;
	}
	
	public void addSelectedList(Vector<Model> list) {
		for (Model mLecture : list) {
			mLectureList.add(mLecture);
			take(mLecture);
	    }this.table.updateUI();
	}
	
	public void removeSelectedList(Vector<Model> list) {
       for (Model mLecture : list) {
           int index = mLectureList.indexOf(mLecture);
           if (index != -1) {
        	   mLectureList.remove(index);
	           this.model.removeRow(index);
           }
       }
       this.table.updateUI();
	}
	
}