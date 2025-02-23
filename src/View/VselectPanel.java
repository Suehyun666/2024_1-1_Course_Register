package View;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Constant.constant.select;

import java.awt.LayoutManager;
import java.util.Vector;

public class VselectPanel extends JPanel{
	//version
	private static final long serialVersionUID = select.VERSION_NUM;
	
	//components
	private VindexPanel vindexpanel;
	private VlectureScrollPane vlectureTable;
	
	//constructor
	public VselectPanel() {
		//attributes
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		//components
		this.vindexpanel = new VindexPanel();
		this.add(this.vindexpanel);
		
		this.vlectureTable = new VlectureScrollPane();
		this.add(this.vlectureTable);
		
		//associate
		this.vindexpanel.associate(this.vlectureTable);

	//methods
	}public VlectureScrollPane getLectureTable() {
		return vlectureTable;
		
	}//initialize
	public void initialize() {
		this.vindexpanel.initialize();
		this.vlectureTable.initialize();
	}
}
