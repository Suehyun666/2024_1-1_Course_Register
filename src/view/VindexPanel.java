package view;

import javax.swing.JPanel;

import contants.Constant.indexpanel;

import javax.swing.*;
import java.awt.*;

public class VindexPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	// components
	private VIndexTable vCampus;
	private VIndexTable vCollege;
	private VIndexTable vDepartment;

	// constructors
	public VindexPanel(){
		// attributes
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);

		this.vCampus = new VIndexTable();
		this.add(vCampus);
		this.vCollege = new VIndexTable();
		this.add(vCollege);
	
		this.vDepartment = new VIndexTable();
		this.add(vDepartment);
	
		//associations
		this.vCampus.setNext(vCollege);
		this.vCollege.setNext(vDepartment);
	}

	public void initialize() {
		this.vCampus.initialize();
		this.vCollege.initialize();
		this.vDepartment.initialize();
		this.vCampus.show(indexpanel.ROOT);
	}
	
	//associate
	public void associate(VlectureScrollPane vlecture) {
		this.vDepartment.setNext(vlecture);
	}
}