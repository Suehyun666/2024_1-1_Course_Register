package View;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import Constant.constant.sugang;


public class Vsuganagsinchung extends JPanel {
	//version
    private static final long serialVersionUID = sugang.VERSION_NUM;
    //components
	private JPanel menupanel;
    private VselectPanel  Vselectpanel;
	private VSEARCH vsearchpanel;
	private VMIRI vMiridamgiPanel;
	private VControlPanel vcontrolpanel;
	private Vsincheong vSincheongpanel;
	private JButton showbasket,showselect,showsearch,showmy;
	//constructor
    public Vsuganagsinchung() {
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
        this.vMiridamgiPanel=new VMIRI();
        this.vMiridamgiPanel.setVisible(false);
		this.add(this.vMiridamgiPanel);
        //select
    	this.Vselectpanel = new VselectPanel(); 
        this.Vselectpanel.setVisible(false);
    	this.add(this.Vselectpanel);
        //search
        this.vsearchpanel = new VSEARCH();
        this.vsearchpanel.setVisible(false);
        this.add(this.vsearchpanel); 
        //sincheong(my lecture)
        this.vSincheongpanel=new Vsincheong();
        this.vSincheongpanel.setVisible(false);
		this.add(this.vSincheongpanel);
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
        this.vcontrolpanel.associate(this.Vselectpanel.getLectureTable(),this.vsearchpanel.getLectureTable(),this.vMiridamgiPanel.getLectureTable(),this.vSincheongpanel.getLectureTable());
    }
    
    //action handler (show panel menu)
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
            	case sugang.SHOWBASKET:
            		showPanel(vMiridamgiPanel);
                	break;
                case sugang.SHOWSEARCH:
                    showPanel(vsearchpanel);
                    break;
                case sugang.SHOWSELECT:
                    showPanel(Vselectpanel);
                    break;
                case sugang.SHOWMY:
                	showPanel(vSincheongpanel);
                	break;}
     }

    //methods
	private void showPanel(JPanel panel) {
    	initialize();
    	Vselectpanel.setVisible(false);
    	vsearchpanel.setVisible(false);
    	vMiridamgiPanel.setVisible(false);
    	vSincheongpanel.setVisible(false);
        panel.setVisible(true); 
        vcontrolpanel.setVisible(true);
       }
    }
    //run
    public void run() {
        
    }
    //association
	public void setNext(MyInfo myinfo) {
		this.vcontrolpanel.setNext(myinfo);
		
	}
	
	//initialize
    public void initialize() {
    	this.Vselectpanel.initialize();      
    	this.vsearchpanel.initialize();
    	this.vMiridamgiPanel.initialize();
    	this.vSincheongpanel.initialize();
    }
}
