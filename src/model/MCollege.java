package model;

public class MCollege {
    private int collegeId;
    private int campusId;
    private String name;

    public MCollege(int collegeId, int campusId, String name) {
        this.collegeId = collegeId;
        this.campusId = campusId;
        this.name = name;
    }

    public int getCollegeId() {
        return collegeId;
    }
    public void setCollegeId(int collegeId) {this.collegeId = collegeId;}

    public int getCampusId() {return campusId;}
    public void setCampusId(int campusId) {this.campusId = campusId;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
}
