package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constant.Constants.indexTable.EHeader;
import controller.LectureController;
import model.IndexItem;


public class VIndexTable extends JScrollPane implements IindexTable {
	private static final long serialVersionUID = 1L;
	
	//components
	private JTable table;
	private DefaultTableModel model;
	private Vector<IndexItem> items;
    private LectureController lectureController;
	
	//association
	private IindexTable next;
	public void setNext(IindexTable next) {this.next = next;}
	
	//constructor
	public VIndexTable() {
		//components
		this.table = new JTable();
		this.setViewportView(this.table);

		String[] header = {EHeader.EID.getTitle(), EHeader.ETITLE.getTitle()};
		this.model = new DefaultTableModel(null, header);
		this.table.setModel(model);
        this.lectureController = new LectureController();

        MouseHandler mousehandler =new MouseHandler();
        this.table.addMouseListener(mousehandler);
	}
	
	//methods	
	public void show(String link) {
		items = lectureController.getDirectories(link);
		this.model.setRowCount(0);
		if (items != null && !items.isEmpty()) {
        	for (IndexItem item: items) {
        	    String[] columns = new String[3];
        	    columns[0] = item.getId();
        	    columns[1] = item.getName();
        	    this.model.addRow(columns);
        	}
        	this.showNext(0);
    	} else {
        	this.model.setRowCount(0);
    	}
	}
	
	private void showNext(int row) {
		if(this.next != null && items != null && row < items.size()) {
			this.next.show(items.get(row).getLink());}
	}
	
	//mouse handler
	private class MouseHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		if (row>=0) {showNext(row);	}}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}

	//initialize
	public void initialize() {}
}
