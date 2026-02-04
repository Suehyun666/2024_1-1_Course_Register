package model;

public class Model {
	
	private String id;
	private String name;
	private String name1;
	private String Score;
	private String time;
	private String link;
	
	public Model() {}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLink() {
		return link;
	}
	public String getName1() {
		return name1;
	}
	public String getScore() {
		return Score;
	}
	public String getTime() {
		return time;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setName2(String name) {
		this.name = name;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setScore(String Score) {
		this.Score= Score;
	}
	public void setLink(String link) {
		this.link=link;
	}
}