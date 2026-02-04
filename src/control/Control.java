package control;

import java.util.*;
import model.DAO;
import model.Model;

public class Control {
	
	// components
	private DAO model;
	
	// constructors
	public Control() {}
	
	// methods
	public Vector<Model> getList(String Filename) {
		this.model= new DAO();
		Vector<Model>List=this.model.getList(Filename);
		return List;
	}
}