package view;

import java.awt.LayoutManager;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Vsuganagsinchung extends JPanel {
    private static final long serialVersionUID = 1L;
    
    // components
    private VselectPane  Vselectpanel;
	private Vcontrol vControl1, vControl2;	
    private VlectureScrollPane vBasket,vSinchung;
    
    public Vsuganagsinchung() {
    	//attributes
    	LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
    	
    	this.Vselectpanel = new VselectPane(); 
    	this.add(this.Vselectpanel);
        
        this.vControl1 = new Vcontrol();
        this.add(this.vControl1); 
        
        this.vBasket=new VlectureScrollPane();
        this.add(vBasket);
        
        this.vControl2 = new Vcontrol();
        this.add(this.vControl2); 
        
        this.vSinchung = new VlectureScrollPane();
        this.add(vSinchung);
        
        // associate
        this.vControl1.associate(Vselectpanel.getLectureTable(), vBasket);
        this.vControl2.associate(vBasket,vSinchung );
    }

    public void initialize() {	
    	this.Vselectpanel.initialize();      
    	this.vControl1.initialize();
    	this.vControl2.initialize();
    	this.vBasket.initialize();
    	this.vSinchung.initialize();
    }
}