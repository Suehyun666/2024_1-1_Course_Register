package View;

import javax.swing.JPanel;

import Constant.constant.indexpanel;

import javax.swing.*;
import java.awt.*;

public class VindexPanel extends JPanel{
	//version
	private static final long serialVersionUID = indexpanel.VERSION_NUM;
	
	//components
	private VIndexTable vCampus;
	private VIndexTable vCollege;
	private VIndexTable vDepartment;
	
	//constructor
	public VindexPanel(){
		
	//attributes
	LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
	this.setLayout(layoutManager);
	
	//components
	this.vCampus = new VIndexTable();
	this.add(vCampus);
	
	this.vCollege = new VIndexTable();
	this.add(vCollege);
	
	this.vDepartment = new VIndexTable();
	this.add(vDepartment);
	
	//associations
	this.vCampus.setNext(this.vCollege);
	this.vCollege.setNext(this.vDepartment);
	}
	
	//initialize
	public void initialize() {
	this.vCampus.initialize();
	this.vCollege.initialize();
	this.vDepartment.initialize();
	
	this.vCampus.show(indexpanel.ROOT);}
	
	//association methods
	public void associate(VlectureScrollPane vlecture) {
	this.vDepartment.setNext(vlecture);}
	
}
