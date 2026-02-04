package model;

import dao.StudentDAO;
import dao.EnrollmentDAO;

public class MStudent {
    private static MStudent currentStudent;
    private static StudentDAO studentDAO = new StudentDAO();
    private static EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    private int studentId;
    private String password;
    private String name;
    private int deptId;
    private int maxCredits;

    // constructor
    public MStudent(int studentId, String password, String name, int deptId, int maxCredits) {
        this.studentId = studentId;
        this.password = password;
        this.name = name;
        this.deptId = deptId;
        this.maxCredits = maxCredits;
    }

    public static MStudent login(int studentId, char[] rawPassword) {
        String hashedPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(new String(rawPassword));
        MStudent student = studentDAO.login(studentId, hashedPassword);
        if (student != null) {
            currentStudent = student;
        }
        return student;
    }

    // methods
    public static void logout() {currentStudent = null;}
    public boolean canEnrollCredits(int credits) {return getRemainingCredits() >= credits;}

    // getters and setters
    public int getStudentId() {return studentId;}
    public String getName() {return name;}
    public int getMaxCredits() {return maxCredits;}
    public int getEnrolledCredits() {return enrollmentDAO.getEnrolledCredits(this.studentId);}
    public int getRemainingCredits() {return this.maxCredits - getEnrolledCredits();}
    public static MStudent getCurrentStudent() {return currentStudent;}
    public void setName(String name) {this.name = name;}
}
