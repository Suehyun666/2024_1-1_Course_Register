package view.panel;

import view.VlectureScrollPane;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class VBasketPanel extends JPanel {
	private static final long serialVersionUID = 1L;

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

	//initialize
	public void initialize() {
		this.vBasketScrollpane.initialize();
		this.vBasketScrollpane.showBasket();
	}
}
