package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import constant.Constants.miri;


public class VBasketPanel extends JPanel {
	//version
	private static final long serialVersionUID = miri.VERSION_NUM;
	//components
	private VlectureScrollPane vBasketScrollpane;
	//constructor
	public VBasketPanel() {
		//attribute
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
	
		//components
		this.vBasketScrollpane=new VlectureScrollPane();
		this.add(this.vBasketScrollpane);
	}
	
	//methods
	public VlectureScrollPane getLectureTable() {return vBasketScrollpane;}
	public void run() {}
	//initialize
	public void initialize() {
		this.vBasketScrollpane.initialize();
		this.vBasketScrollpane.showBasket();
	}
}
