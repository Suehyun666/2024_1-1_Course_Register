package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import constant.Constants.controlbt;
import control.Control;

public class VControlPanel extends JPanel {
	//version
	private static final long serialVersionUID = controlbt.VERSION_NUM;
	//components
	private JButton basketbt,enrollmentbt,deletebasketbt,deleteenrollbt;
	//associate
	private MyInfoPanel myinfo;
	private VlectureScrollPane selectpane,searchpane,basketpane,mylecturepane;
	
	//constructor
	public VControlPanel() {
		//attributes
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		ActionHandler actionListener=new ActionHandler();
		
		//components
		//miri
		this.basketbt = new JButton(controlbt.MIRI);
        basketbt.setActionCommand(controlbt.MIRI);
        basketbt.addActionListener(actionListener);
        this.add(basketbt);
        //delete from miri
        this.deletebasketbt = new JButton(controlbt.DELETEMIRI);
        deletebasketbt.setActionCommand(controlbt.DELETEMIRI);
        deletebasketbt.addActionListener(actionListener);
        this.add(deletebasketbt);
        //enrollment
        this.enrollmentbt  = new JButton(controlbt.SINCHEONG);
        enrollmentbt.setActionCommand(controlbt.SINCHEONG);
        enrollmentbt.addActionListener(actionListener);
        this.add(enrollmentbt);
        //delete
        this.deleteenrollbt  = new JButton(controlbt.DELETE);
        deleteenrollbt.setActionCommand(controlbt.DELETE);
        deleteenrollbt.addActionListener(actionListener);
        this.add(deleteenrollbt);
		
	}
	//association
	public void setNext(MyInfoPanel myinfo) {
		this.myinfo=myinfo;
	}
	public void associate(VlectureScrollPane select, VlectureScrollPane search, VlectureScrollPane basket, VlectureScrollPane mylecture) {
		this.selectpane=select;
		this.searchpane=search;
		this.basketpane=basket;
		this.mylecturepane=mylecture;}
	
	//action handler
	private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
            	case controlbt.MIRI:
                	Control(controlbt.MIRI);
                    break;
                case controlbt.SINCHEONG:
                	Control(controlbt.SINCHEONG);
                	break;
                case controlbt.DELETEMIRI:
                	Control(controlbt.DELETEMIRI);
                    break;
                case controlbt.DELETE:
                	Control(controlbt.DELETE);
                    break;
            }
        }
        
        	//methods
        	private void Control(String link) {
        		//select id from which table
        		int courseId0 = basketpane.getcourseid();
        		int courseId1 = selectpane.getcourseid();
        		int courseId2 = searchpane.getcourseid();
        		int courseId3 = mylecturepane.getcourseid();
    		int Id = courseId1+courseId0+courseId2+courseId3+3;
    		//if selected
    		if (Id!=-1) {
    			Control controlFunction =new Control();	
    			if(link==controlbt.SINCHEONG) {
    				controlFunction.enrollment(Id);
    			}else if(link==controlbt.MIRI){
    				controlFunction.basket(Id);
    			}else if(link==controlbt.DELETEMIRI){
    				controlFunction.deletefrombasket(Id);
    			}else if(link==controlbt.DELETE){
    			controlFunction.deletefromenrollment(Id);
    			}else {}
    			//update table
    			if (courseId0 >= 0) {
    				basketpane.showBasket();}	
    			if (courseId1 >= 0) {
    				selectpane.update();}
    			if (courseId2 >= 0) {
    				searchpane.update();}
    			if (courseId3 >= 0) {
    				mylecturepane.showMy();
    			}
    			//update user info
    			myinfo.updateinfo();
    		}else {}
		}
    }
	//initialize
	public void initialize() {}
}