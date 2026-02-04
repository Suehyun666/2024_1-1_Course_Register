package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;

public class Vcontrol extends JPanel {
	private static final long serialVersionUID = 1L;
	
	//components
	private JButton leftbt;
	private JButton rightbt;
	
	//associate
	private VlectureScrollPane right;
	private VlectureScrollPane left;
	
	//constructors
	public Vcontrol() {
		// attributes
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		
		ActionHandler actionhandler=new ActionHandler();
		
		this.leftbt=new JButton("<<");
		this.leftbt.addActionListener(actionhandler);
		this.add(leftbt);
		
		this.rightbt=new JButton(">>");
		this.rightbt.addActionListener(actionhandler);
		this.add(rightbt);	
	}
	
	public void initialize() {}
	
	// associate
	public void associate(VlectureScrollPane left, VlectureScrollPane right) {
		this.right=right;
		this.left=left;	
	}
	
	// methods
	private void moveleft() {	
		Vector<Model> List=this.right.getSelectedList();
		this.left.addSelectedList(List);
		this.right.removeSelectedList(List);
	}
	
	private void moveright() {
		Vector<Model> List=this.left.getSelectedList();
		this.right.addSelectedList(List);
		this.left.removeSelectedList(List);
	}
	
	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==leftbt) {
				moveleft();
			} else if(e.getSource()==rightbt) {
				moveright();
			}
		}
	}
}