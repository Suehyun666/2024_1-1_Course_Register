package model;

public class MDepartment {
    private int deptId;
    private int collegeId;
    private String name;

    public MDepartment(int deptId, int collegeId, String name) {
        this.deptId = deptId;
        this.collegeId = collegeId;
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getCollegeId() {return collegeId;}
    public void setCollegeId(int collegeId) {this.collegeId = collegeId;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
}
