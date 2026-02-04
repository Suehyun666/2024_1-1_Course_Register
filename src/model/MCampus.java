package model;


public class MCampus {
    private int campusId;
    private String name;

    public MCampus(int campusId, String name) {
        this.campusId = campusId;
        this.name = name;
    }

    public int getCampusId() {
        return campusId;
    }
    public void setCampusId(int campusId) {this.campusId = campusId;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}
}
