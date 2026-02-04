package controller;
import constant.Constants;

import dao.EnrollmentDAO;
import dao.LectureDAO;
import model.MLecture;
import model.MStudent;
import view.panel.VControlPanel;

import java.util.List;

public class EnrollmentController {
    private VControlPanel view;
    private EnrollmentDAO enrollmentDAO;
    private LectureDAO lectureDAO;

    public EnrollmentController() {
        this(null);
    }

    public EnrollmentController(VControlPanel view) {
        this.view = view;
        this.enrollmentDAO = new EnrollmentDAO();
        this.lectureDAO = new LectureDAO();
    }

    public void enroll(int lectureId) {
        try {
            MStudent student = MStudent.getCurrentStudent();
            if (student == null) throw new Exception(Constants.ErrorMessage.LOGIN_REQUIRED);

            int studentId = student.getStudentId();

            if (enrollmentDAO.exists(studentId, lectureId)) {
                throw new Exception(Constants.ErrorMessage.ALREADY_ENROLLED);
            }

            MLecture lecture = lectureDAO.findById(lectureId);
            if (lecture == null) throw new Exception(Constants.ErrorMessage.LECTURE_NOT_FOUND);

            int enrolledCount = lectureDAO.getEnrolledCount(lectureId);
            if (enrolledCount >= lecture.getCapacity()) {
                throw new Exception(Constants.ErrorMessage.CAPACITY_EXCEEDED);
            }

            if (!student.canEnrollCredits(lecture.getCredits())) {
                throw new Exception(Constants.ErrorMessage.CREDITS_EXCEEDED);
            }

            List<MLecture> enrolledLectures = enrollmentDAO.getStudentLectures(studentId);
            for (MLecture enrolled : enrolledLectures) {
                if (lecture.isOverlapping(enrolled)) {
                    throw new Exception(Constants.ErrorMessage.TIME_CONFLICT);
                }
            }

            enrollmentDAO.insert(studentId, lectureId);
            view.showSuccess(Constants.Message.ENROLL_SUCCESS);
            view.refreshAll();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void cancelEnrollment(int lectureId) {
        try {
            MStudent student = MStudent.getCurrentStudent();
            if (student == null) throw new Exception(Constants.ErrorMessage.LOGIN_REQUIRED);

            int studentId = student.getStudentId();

            if (!enrollmentDAO.exists(studentId, lectureId)) {
                throw new Exception(Constants.ErrorMessage.NOT_ENROLLED);
            }

            enrollmentDAO.delete(studentId, lectureId);
            view.showSuccess(Constants.Message.ENROLL_CANCEL_SUCCESS);
            view.refreshAll();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }


    public List<MLecture> getEnrolledLectures() {
        MStudent student = MStudent.getCurrentStudent();
        if (student == null) {
            return new java.util.ArrayList<>();
        }
        return enrollmentDAO.getStudentLectures(student.getStudentId());
    }

}
