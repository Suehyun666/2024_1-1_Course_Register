package model;

public class Model {
	
	private String id;
	private String name;
	private String name1;
	private String proname;
	private String dept;
	private String Score;
	private String Scorelimit;
	private String time;
	private String link;
	private String day;
	private String wishpeople;
	private String people;
	private String peoplelimit;
	
	private int courseScore;
	private int ScoreLimit;
	private int stScore;
	
	public Model() {}
	
	// get methods
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getName1() {
		return name1;
	}
	public String getProname() {
		return proname;
	}
	public String getDept() {
		return dept;
	}
	public String getScore() {
		return Score;
	}
	public String getScorelimit() {
		return Scorelimit;
	}
	public String getTime() {
		return time;
	}
	public String getLink() {
		return link;
	}
	public String getday() {
		return day;
	}
	public String getwishpeople() {
		return wishpeople;
	}
	public String getPeople() {
		return people;
	}
	public String getPeoplelimit() {
		return peoplelimit;
	}
	public int getcourseScore() {
		return courseScore;
	}
	public int getScoreLimit() {
		return ScoreLimit;
	}
	public int getstScore() {
		return stScore;
	}
	
	// set methods
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setScore(String Score) {
		this.Score= Score;
	}
	public void setScorelimit(String Scorelimit) {
		this.Scorelimit= Scorelimit;
	}
	public void setwhishpeople(String wishpeople) {
		this.wishpeople= wishpeople;
	}
	public void setPeople(String people) {
		this.people= people;
	}
	public void setPeoplelimit(String peoplelimit) {
		this.peoplelimit= peoplelimit;
	}
	public void setday(String day) {
		this.day=day;
	}
	public void setLink(String link) {
		this.link=link;
	}
	public void setcourseScore(int courseScore) {
		this.courseScore=courseScore;
	}
	public void setScoreLimit(int ScoreLimit) {
		this.ScoreLimit=ScoreLimit;
	}
	public void setstScore(int stScore) {
		this.stScore = stScore;
	}
	
}