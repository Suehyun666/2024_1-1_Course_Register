package view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import contants.Constant.mainframe;

public class Vmainframe extends JFrame {
	private static final long serialVersionUID = mainframe.VERSION_NUM;
	
	//components
	private Vsuganagsinchung vsuganagsinchung;
	
	//constructors
	public Vmainframe() throws HeadlessException{
		//attributes
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int windowWidth = screenSize.width * 2 / 3;  
		int windowHeight = screenSize.height * 2 / 3;
		int x = (screenSize.width - windowWidth) / 2;
		int y = (screenSize.height - windowHeight) / 2;
		
		this.setTitle(mainframe.TITLE);
		this.setSize(windowWidth, windowHeight);
		this.setLocation(x,y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		this.vsuganagsinchung=new Vsuganagsinchung();
		this.add(vsuganagsinchung);
		
	}

	public void initialize() {
		this.vsuganagsinchung.initialize();
	}
}
