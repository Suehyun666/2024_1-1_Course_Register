package View;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constant.constant.miri;
import Constant.constant.controlbt;
import Control.Control;
import Model.Model;


public class VMIRI extends JPanel {
	//version
	private static final long serialVersionUID = miri.VERSION_NUM;
	//components
	private VlectureScrollPane VMiri;
	//constructor
	public VMIRI() {
		
	//attribute
	LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
	this.setLayout(layoutManager);
	
	//components
    
    this.VMiri=new VlectureScrollPane();
    this.add(this.VMiri);}
	
	//methods
	public void run() {}
	
	public VlectureScrollPane getLectureTable() {
		return VMiri;
	}
	
	//initialize
	public void initialize() {
	this.VMiri.initialize();
	this.VMiri.showBasket();
	}
}
