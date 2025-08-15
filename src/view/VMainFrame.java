package view;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import constant.Constants.mainframe;
import control.Control;

public class VMainFrame extends JFrame {
	//version
	private static final long serialVersionUID = mainframe.VERSION_NUM;
	
	//components	
	private MyInfoPanel myinfo;
	private VMainPanel  Vsuganagsinchung;

	//constructor
	public VMainFrame() throws HeadlessException{
		//attribute
		this.setTitle(mainframe.TITLE);
        this.setSize(mainframe.Width, mainframe.Height);
        this.setLocation(mainframe.x, mainframe.y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ActionHandler actionListener = new ActionHandler();
        
        //components
		this.myinfo=new MyInfoPanel();
        this.myinfo.setPreferredSize(new Dimension(1000, 40));
        this.myinfo.setVisible(true);
    	this.add(this.myinfo);
        
        this.Vsuganagsinchung = new VMainPanel();
        this.Vsuganagsinchung.setVisible(true);
    	this.add(this.Vsuganagsinchung);
    	
		//button
    	JButton logoutbt = new JButton(mainframe.LOGOUT);
        logoutbt.setActionCommand(mainframe.LOGOUT);
        logoutbt.addActionListener(actionListener);
        this.myinfo.add(logoutbt);
        
        //associate
        this.Vsuganagsinchung.setNext(this.myinfo);
        
        
    //action event 
	}private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case mainframe.LOGOUT:
                	logout();
                    break;
            	}
        	}
        //methods
		private void logout() {
			dispose();
        	Control control =new Control();
        	control.clearUserId();
            LoginFrame log =new LoginFrame();
            log.setVisible(true);
			
		}
	
	
	}//initialize
	public void initialize() {
		this.Vsuganagsinchung.initialize();
		this.myinfo.initialize();
	}
}
