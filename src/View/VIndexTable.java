package View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Constant.constant.indexTable.EHeader;
import Constant.constant.indextable;
import Control.Control;
import Model.Model;


public class VIndexTable extends JScrollPane implements iindexTable{
	//version
	private static final long serialVersionUID = indextable.VERSION_NUM;
	
	//components
	private JTable table;
	private DefaultTableModel model;
	private Vector<Model> List;
	
	//association
	private iindexTable next;
	public void setNext(iindexTable next) {this.next = next;}
	
	//constructor
	public VIndexTable() {
		//components
		//table
		this.table = new JTable();
		this.setViewportView(this.table);
		//model
		String[] header = {EHeader.EID.getTitle(), EHeader.ETITLE.getTitle()};
		this.model = new DefaultTableModel(null, header);
		this.table.setModel(model);
		//attributes
        MouseHandler mousehandler =new MouseHandler();
        this.table.addMouseListener(mousehandler);
	}
	//methods	
	public void show(String link) {
		Control cIndex = new Control();
		List = cIndex.getList(link);
		this.model.setRowCount(0);
		for (Model mCampus: List) {
			String[] colums = new String[3];
			colums[0] = String.valueOf(mCampus.getId());
			colums[1] = mCampus.getName();
			colums[2] = mCampus.getLink();
			this.model.addRow(colums);		
		}this.showNext(0);}
	
	private void showNext(int row) {
		if(this.next != null) {
			this.next.show(List.get(row).getLink());}
		
	//mouse handler
	}private class MouseHandler implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			if (row>=0) {
				showNext(row);	}	}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
	//initialize	
	}public void initialize() {}
}
