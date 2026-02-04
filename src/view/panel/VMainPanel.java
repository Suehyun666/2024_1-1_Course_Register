package view.panel;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import constant.Constants.sugang;


public class VMainPanel extends JPanel {
	//version
    private static final long serialVersionUID = 1L;

    //components
	private JPanel menupanel;
    private VSelectPanel  Vselectpanel;
	private VSearchPanel vsearchpanel;
	private VBasketPanel vBasketpanel;
	private VControlPanel vcontrolpanel;
	private VEnrollment vEnrollmentpanel;
	private JButton showbasket,showselect,showsearch,showmy;
    
	//constructor
    public VMainPanel() {
    	//attributes
    	ActionHandler actionListener = new ActionHandler();
    	LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
    	
    	//components
		//menu
		this.menupanel=new JPanel();
		this.menupanel.setVisible(true);
        this.add(this.menupanel);    
        //miri
        this.vBasketpanel=new VBasketPanel();
        this.vBasketpanel.setVisible(false);
		this.add(this.vBasketpanel);
        //select
    	this.Vselectpanel = new VSelectPanel(); 
        this.Vselectpanel.setVisible(false);
    	this.add(this.Vselectpanel);
        //search
        this.vsearchpanel = new VSearchPanel();
        this.vsearchpanel.setVisible(false);
        this.add(this.vsearchpanel); 
        //sincheong(my lecture)
        this.vEnrollmentpanel=new VEnrollment();
        this.vEnrollmentpanel.setVisible(false);
		this.add(this.vEnrollmentpanel);
        //control panel
        this.vcontrolpanel=new VControlPanel();
        this.vcontrolpanel.setVisible(false);
        this.add(this.vcontrolpanel); 
        
        // button
        
        //show basket
        this.showbasket = new JButton(sugang.BASKET);
        showbasket.setActionCommand(sugang.SHOWBASKET);
        showbasket.addActionListener(actionListener);
        this.menupanel.add(showbasket);
        //show select
        this.showselect = new JButton(sugang.SELECT);
        showselect.setActionCommand(sugang.SHOWSELECT);
        showselect.addActionListener(actionListener);
        this.menupanel.add(showselect);
        //show search
        this.showsearch = new JButton(sugang.SEARCH);
        showsearch.setActionCommand(sugang.SHOWSEARCH);
        showsearch.addActionListener(actionListener);
        this.menupanel.add(showsearch);
        //show my lecture
        this.showmy = new JButton(sugang.MY);
        showmy.setActionCommand(sugang.SHOWMY);
        showmy.addActionListener(actionListener);
        this.menupanel.add(showmy);
        
        
        //association
        this.vcontrolpanel.associate(this.Vselectpanel.getLectureTable(),this.vsearchpanel.getLectureTable(),this.vBasketpanel.getLectureTable(),this.vEnrollmentpanel.getLectureTable());
    }
    
    //action handler (show panel menu)
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
            	case sugang.SHOWBASKET:
            		showPanel(vBasketpanel);
                	break;
                case sugang.SHOWSEARCH:
                    showPanel(vsearchpanel);
                    break;
                case sugang.SHOWSELECT:
                    showPanel(Vselectpanel);
                    break;
                case sugang.SHOWMY:
                	showPanel(vEnrollmentpanel);
                	break;}
     }

    //methods
	private void showPanel(JPanel panel) {
    	initialize();
    	Vselectpanel.setVisible(false);
    	vsearchpanel.setVisible(false);
    	vBasketpanel.setVisible(false);
    	vEnrollmentpanel.setVisible(false);
        panel.setVisible(true); 
        vcontrolpanel.setVisible(true);
       }
    }
    //run
    public void run() {
        
    }
    public void setInfoPanel(MyInfoPanel myinfo) {
        this.vcontrolpanel.setInfoPanel(myinfo);
    }
	
	//initialize
    public void initialize() {
    	this.Vselectpanel.initialize();      
    	this.vsearchpanel.initialize();
    	this.vBasketpanel.initialize();
    	this.vEnrollmentpanel.initialize();
    }
}
