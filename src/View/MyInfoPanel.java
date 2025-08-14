package view;

import javax.swing.*;

import constant.Constants.myinfo;
import control.Control;
import model.Model;

import java.util.Vector;

public class MyInfoPanel extends JPanel {
	//version
    private static final long serialVersionUID = myinfo.VERSION_NUM;
    //components
    private JLabel userNameLabel,userScoreLabel;
    //model
    private Vector<Model> List;
    //constructor
    public MyInfoPanel() {
    	//attributes
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //components
        this.userNameLabel = new JLabel(myinfo.NAME);
        this.userScoreLabel = new JLabel(myinfo.SCORE);

        this.add(userNameLabel);
        this.add(userScoreLabel);
        //method
        updateinfo();
    }
    
    //methods
    public void setUserInfo(Vector<Model> userInfoVector) {
    	
        StringBuilder userNameText = new StringBuilder(myinfo.NAME);
        StringBuilder userScoreText = new StringBuilder(myinfo.SCORE);
        for (Model userInfo : userInfoVector) {
            userNameText.append(userInfo.getName()).append(myinfo.BLAMK);
            userScoreText.append(userInfo.getstScore()).append(myinfo.SLASH);
            userScoreText.append(userInfo.getScoreLimit()).append(myinfo.BLAMK);
        }
        this.userNameLabel.setText(userNameText.toString());
        this.userScoreLabel.setText(userScoreText.toString());
    }
    
    //update 
    public void updateinfo() {
    	Control control =new Control();
    	List=control.myinfo();
    	setUserInfo(List);
    }
    //initialize
	public void initialize() {}
}

