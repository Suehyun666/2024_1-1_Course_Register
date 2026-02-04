package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import contants.Constant.indexTable;
import contants.Constant.indexTable.EHeader;
import contants.Constant.lecture.ElectureHeader;
import control.Control;
import model.Model;


public class VIndexTable extends JScrollPane implements IindexTable{
	private static final long serialVersionUID = 1L;
	
	// components
	private JTable table;
	private DefaultTableModel model;
	private Vector<Model> List;
	private IindexTable next;
	
	public VIndexTable() {
		// attributes
		this.table = new JTable();
		this.setViewportView(this.table);
		
		String[] header = { EHeader.EID.getTitle(), EHeader.ETITLE.getTitle()};
		this.model = new DefaultTableModel(null, header);
		
		MouseHandler mousehandler =new MouseHandler();
        this.table.addMouseListener(mousehandler);
		
		// associate
		this.table.setModel(model);
	}
	
	// initialize
	public void initialize() {}
	
	// associate
	public void setNext(IindexTable next) {this.next = next;}
	
	// methods
	public void show(String link) {
		Control cIndex = new Control();
		List = cIndex.getList(link);
		this.model.setRowCount(0);
		for (Model mCampus: List) {
			String[] colums = new String[2];
			colums[0] = String.valueOf(mCampus.getId());
			colums[1] = mCampus.getName();
			this.model.addRow(colums);		
		}
		this.showNext(0);
	}
	
	private void showNext(int row) {
		if(this.next != null) {
			this.next.show(List.get(row).getLink());	
		}	
	}

	private class MouseHandler implements MouseListener {	
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			if (row>=0) {
				showNext(row);	
			}	
		}
		@Override
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
}
