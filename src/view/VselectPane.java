package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.LayoutManager;
import java.util.Vector;

public class VselectPane extends JPanel{
	private static final long serialVersionUID = 1L;
	
	//components
	private VindexPanel vindex;
	private VlectureScrollPane vlecture;
	
	//constructors
	public VselectPane() {
		// attributes
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		this.vindex = new VindexPanel();
		this.add(this.vindex);
		
		this.vlecture = new VlectureScrollPane();
		this.add(this.vlecture);
		
		// associate
		this.vindex.associate(this.vlecture);
	}
	
	//initialize
	public void initialize() {
		this.vindex.initialize();
		this.vlecture.initialize();
	}
	
	// methods
	public VlectureScrollPane getLectureTable() {
		return vlecture;
	}
}