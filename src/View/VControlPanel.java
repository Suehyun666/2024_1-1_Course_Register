package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Constant.constant.control;
import Constant.constant.controlbt;
import Control.Control;



public class VControlPanel extends JPanel {
	//version
	private static final long serialVersionUID = controlbt.VERSION_NUM;
	//components
	private JButton miri,sincheong,Delmiri,deletebt;
	//associate
	private MyInfo myinfo;
	private VlectureScrollPane select,search,basket,mylecture;
	
	//constructor
	public VControlPanel() {
		//attributes
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		ActionHandler actionListener=new ActionHandler();
		
		
		//components button 
		//miri
		this.miri = new JButton(controlbt.MIRI);
        miri.setActionCommand(controlbt.MIRI);
        miri.addActionListener(actionListener);
        this.add(miri);
        //delete from miri
        this.Delmiri = new JButton(controlbt.DELETEMIRI);
        Delmiri.setActionCommand(controlbt.DELETEMIRI);
        Delmiri.addActionListener(actionListener);
        this.add(Delmiri);
        //enrollment
        this.sincheong  = new JButton(controlbt.SINCHEONG);
        sincheong.setActionCommand(controlbt.SINCHEONG);
        sincheong.addActionListener(actionListener);
        this.add(sincheong);
        //delete
        this.deletebt  = new JButton(controlbt.DELETE);
        deletebt.setActionCommand(controlbt.DELETE);
        deletebt.addActionListener(actionListener);
        this.add(deletebt);
		
	}
	//association
	public void setNext(MyInfo myinfo) {
		this.myinfo=myinfo;
	}
	public void associate(VlectureScrollPane select, VlectureScrollPane search, VlectureScrollPane basket, VlectureScrollPane mylecture) {
		this.select=select;
		this.search=search;
		this.basket=basket;
		this.mylecture=mylecture;}
	
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
    	int courseId0 = basket.getcourseid();
    	int courseId1 = select.getcourseid();
    	int courseId2 = search.getcourseid();
    	int courseId3 = mylecture.getcourseid();
    	int Id = courseId1+courseId0+courseId2+courseId3+3;
    	//if selected
    	if (Id!=-1) {
    		Control controlFunction =new Control();	
    		if(link==controlbt.SINCHEONG) {
    			controlFunction.GO(Id);
    			
    		}else if(link==controlbt.MIRI){
    			controlFunction.Basket(Id);
    			
    		}else if(link==controlbt.DELETEMIRI){
    			controlFunction.DELBasket(Id);
    			
    		}else if(link==controlbt.DELETE){
    			controlFunction.del(Id);
    			
    		}else {}
    		//update table
    		if (courseId0 >= 0) {
    	        basket.showBasket();}	
    		if (courseId1 >= 0) {
    	        select.update();}
    	    if (courseId2 >= 0) {
    	        search.update();}
    	    if (courseId3 >= 0) {
    	        mylecture.showMy();
    	    }
    	    //update user info
    	    myinfo.updateinfo();
    	}
    	
    	else {}
		}

	//initialize
    }public void initialize() {
		
	}
}