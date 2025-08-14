package control;

import java.util.Vector;
import org.apache.commons.codec.digest.DigestUtils;

import constant.Constants.control;
import model.Dao;
import model.Model;

public class Control {
	//components
	private Dao model;
	private static ThreadLocal<Integer> userId = new ThreadLocal<>();

	//constructor
	public Control() {	this.model= new Dao(); }
	   
	//methods
	
	//set id
	public static void setUserId(int id) {userId.set(id);}
	//clear id
    public static void clearUserId() {userId.remove(); }
    
    //id 
  	public boolean IsID(int id) {return model.isId(id);}
  	//password
  	public boolean IsPw(char[] password) {return model.isPw(hashPassword(password));}
  	//hashing 
  	private String hashPassword(char[] password) {return DigestUtils.sha256Hex(new String(password));}
  	 
	//강좌 표시 관련
  	
  	//select campus list
	public Vector<Model> getList(String Filename) {
		Vector<Model>List=this.model.getList(Filename);
		return List;
	}
	//department -> lecture
	public Vector<Model> getLecture(String department) {
		Vector<Model>List=this.model.getLectureByLink(department);
		return List;
	}
	//my lecture
	public Vector<Model> getMyEnrollment() {
		Vector<Model>List=this.model.show(userId.get(),control.ENROLLMENT);
		return List;
	}
	//basket
	public Vector<Model> getBasket() {
		Vector<Model>List=this.model.show(userId.get(),control.BASKET);
		return List;
	}
	//search 
	public Vector<Model> getsearch(String link) {
		Vector<Model>List=this.model.getLectureKeyword(link);
		return List;
	}

	
	//강좌 기능 메소드
	//enrollment		
	public void enrollment(int strid) {
		this.model.toEnrollment(userId.get(),strid);
	}
	//delete 
	public void deletefromenrollment(int strid) {
		this.model.delete(userId.get(),strid);
		
	}//basket
	public void basket(int strid) {
		this.model.toBasket(userId.get(),strid);
	}
	//delete from basket
	public void deletefrombasket(int strid) {
		this.model.delbasket(userId.get(),strid);
		
	}

	//get my infomation
	public Vector<Model> myinfo() {
		Vector<Model>List=this.model.myinfo(userId.get());
		return List;
	}

}