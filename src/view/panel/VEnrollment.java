package view.panel;

import view.VlectureScrollPane;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VEnrollment extends JPanel {
	private static final long serialVersionUID = 1L;

	//components	
	private VlectureScrollPane vsincheong;

	//constructor
	public VEnrollment() {
		//attribute
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		//components
		this.vsincheong=new VlectureScrollPane();
		this.add(vsincheong);
	}
	
	//initialize
	public void initialize() {
		this.vsincheong.initialize();
		this.vsincheong.showMy();
	}

	//methods
	public VlectureScrollPane getLectureTable() {
		return vsincheong;
	}
	
}



