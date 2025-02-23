package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Constant.constant.search;
import Control.Control;


public class VSEARCH extends JPanel {
	//version
	private static final long serialVersionUID = search.VERSION_NUM;
	//components	
	private JTextField searchField;
	private VlectureScrollPane vsearchtable;
	private JPanel searchpanael;
	
	private String keyword;
	//constructor
	public VSEARCH() {
		
		//attribute
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
						
		//components
		this.searchpanael =new JPanel();
		this.add(searchpanael);
        
		//field
		this.searchField = new JTextField(20);
		this.searchField.getDocument().addDocumentListener(new SearchFieldListener());
        this.searchpanael.add(searchField);
		//lecture scrollpanel
		this.vsearchtable=new VlectureScrollPane();
		this.add(vsearchtable);
		
	}
	//methods
	public VlectureScrollPane getLectureTable() {
		return vsearchtable;
	}
	//searching methods
	public void search() {
		//this.model.setcountrow(0)
		this.vsearchtable.clear();
		this.keyword = searchField.getText();
        //add row
        this.vsearchtable.showSearch(keyword);
        
	}
	//listener
	private class SearchFieldListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            search();}

        @Override
        public void removeUpdate(DocumentEvent e) {
            search();
            }

        @Override
        public void changedUpdate(DocumentEvent e) {
            search();}

		
    }//initialize
    public void initialize() {
		this.vsearchtable.initialize();
	}
}
