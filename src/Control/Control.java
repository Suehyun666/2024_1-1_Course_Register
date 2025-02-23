package Control;

import java.util.Vector;
import org.apache.commons.codec.digest.DigestUtils;

import Constant.constant.control;
import Model.DAO;
import Model.Model;

public class Control {
	//components
	private DAO model;
	//save id 
	private static ThreadLocal<Integer> userId = new ThreadLocal<>();
	//constructor
	public Control() {	this.model= new DAO(); }
	   
	//methods
	
	//login methods
	//set id
	public static void setUserId(int id) {
        userId.set(id);}
	//clear id
    public static void clearUserId() {
        userId.remove(); }
    //get id
    public static int getUserId() {
        return userId.get();}
    
    //id 
  	public boolean IsID(int id) {
  		return model.IsId(id);
  	}
  	//password
  	public boolean IsPw(char[] password) {
  		return model.IsPw(hashPassword(password));
  	}
  	//hashing 
  	private String hashPassword(char[] password) {
  		return DigestUtils.sha256Hex(new String(password));
     }
  	 
	//강좌 표시 관련
  	
  	//select campus list
	public Vector<Model> getList(String Filename) {
		Vector<Model>List=this.model.getList(Filename);
		return List;
	}
	//department-> lecture
	public Vector<Model> getLecture(String department) {
		Vector<Model>List=this.model.getLectureByLink(department);
		return List;
	//my lecture
	}public Vector<Model> getMy() {
		Vector<Model>List=this.model.show(userId.get(),control.ENROLLMENT);
		return List;
	//basket	
	}public Vector<Model> getBasket() {
		Vector<Model>List=this.model.show(userId.get(),control.BASKET);
		return List;
	}
	//search 
	public Vector<Model> getsearch(String link) {
		Vector<Model>List=this.model.getLectureKeyword(link);
		return List;
	}

	
	//강좌 기능 메소드
	
	//delete
	public void del(int strid) {
		this.model.Delete(userId.get(),strid);
		
	}//basket
	public void Basket(int strid) {
		this.model.ToBasket(userId.get(),strid);
	}
	//enrollment
	public void GO(int strid) {
		this.model.ToEnrollment(userId.get(),strid);
		
	}
	//delete from basket
	public void DELBasket(int strid) {
		this.model.DELBasket(userId.get(),strid);
		
	}

	
	//get my infomation
	public Vector<Model> myinfo() {
		Vector<Model>List=this.model.myinfo(userId.get());
		return List;
	}

	


	


}