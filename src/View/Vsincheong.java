package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constant.constant.miri;
import Constant.constant.controlbt;
import Constant.constant.my;
import Control.Control;
import Model.Model;


public class Vsincheong extends JPanel {
	//version
	private static final long serialVersionUID = my.VERSION_NUM;
	//components	
	private VlectureScrollPane vsincheong;
	//constructor
	public Vsincheong() {
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



