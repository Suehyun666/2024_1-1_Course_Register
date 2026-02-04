package controller;
import constant.Constants;

import dao.BasketDAO;
import model.MLecture;
import model.MStudent;
import view.panel.VControlPanel;

import java.util.List;

public class BasketController {
    private VControlPanel view;
    private BasketDAO basketDAO;

    public BasketController() {
        this(null);
    }

    public BasketController(VControlPanel view) {
        this.view = view;
        this.basketDAO = new BasketDAO();
    }

    public void addToBasket(int lectureId) {
        try {
            MStudent student = MStudent.getCurrentStudent();
            if (student == null) throw new Exception(Constants.ErrorMessage.LOGIN_REQUIRED);

            int studentId = student.getStudentId();

            if (basketDAO.exists(studentId, lectureId)) {
                throw new Exception(Constants.ErrorMessage.ALREADY_IN_BASKET);
            }

            basketDAO.insert(studentId, lectureId);
            view.showSuccess(Constants.Message.BASKET_ADD_SUCCESS);
            view.refreshAll();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public void removeFromBasket(int lectureId) {
        try {
            MStudent student = MStudent.getCurrentStudent();
            if (student == null) throw new Exception(Constants.ErrorMessage.LOGIN_REQUIRED);

            int studentId = student.getStudentId();

            if (!basketDAO.exists(studentId, lectureId)) {
                throw new Exception(Constants.ErrorMessage.NOT_IN_BASKET);
            }

            basketDAO.delete(studentId, lectureId);
            view.showSuccess(Constants.Message.BASKET_REMOVE_SUCCESS);
            view.refreshAll();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }

    public List<MLecture> getBasketLectures() {
        MStudent student = MStudent.getCurrentStudent();
        if (student == null) {
            return new java.util.ArrayList<>();
        }
        return basketDAO.getStudentBasketLectures(student.getStudentId());
    }
}
