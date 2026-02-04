package view.panel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constant.Constants.controlbt;
import controller.BasketController;
import controller.EnrollmentController;
import view.VlectureScrollPane;

public class VControlPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private EnrollmentController enrollmentController;
    private BasketController basketController;

    // components
    private JButton basketBtn, enrollBtn, deleteBasketBtn, deleteEnrollBtn;
    private MyInfoPanel myinfo;
    private VlectureScrollPane selectPane, searchPane, basketPane, myLecturePane;

    // constructor
    public VControlPanel() {
        this.enrollmentController = new EnrollmentController(this);
        this.basketController = new BasketController(this);

        // attribute
        BoxLayout layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layoutManager);

        this.basketBtn = new JButton(controlbt.MIRI);
        basketBtn.addActionListener(e -> handleBasket());
        this.add(basketBtn);

        this.deleteBasketBtn = new JButton(controlbt.DELETEMIRI);
        deleteBasketBtn.addActionListener(e -> handleDeleteBasket());
        this.add(deleteBasketBtn);

        this.enrollBtn = new JButton(controlbt.SINCHEONG);
        enrollBtn.addActionListener(e -> handleEnroll());
        this.add(enrollBtn);

        this.deleteEnrollBtn = new JButton(controlbt.DELETE);
        deleteEnrollBtn.addActionListener(e -> handleDeleteEnroll());
        this.add(deleteEnrollBtn);
    }

    public void associate(VlectureScrollPane select, VlectureScrollPane search, VlectureScrollPane basket, VlectureScrollPane myLecture) {
        this.selectPane = select;
        this.searchPane = search;
        this.basketPane = basket;
        this.myLecturePane = myLecture;
    }

    public void setInfoPanel(MyInfoPanel myinfo) {
        this.myinfo = myinfo;
    }

    private int getSelectedCourseId() {
        int id0 = basketPane.getcourseid();
        int id1 = selectPane.getcourseid();
        int id2 = searchPane.getcourseid();
        int id3 = myLecturePane.getcourseid();
        return id0 + id1 + id2 + id3 + 3;
    }

    private void handleBasket() {
        int courseId = getSelectedCourseId();
        if (courseId != -1) {
            basketController.addToBasket(courseId);
        }
    }

    private void handleDeleteBasket() {
        int courseId = getSelectedCourseId();
        if (courseId != -1) {
            basketController.removeFromBasket(courseId);
        }
    }

    private void handleEnroll() {
        int courseId = getSelectedCourseId();
        if (courseId != -1) {
            enrollmentController.enroll(courseId);
        }
    }

    private void handleDeleteEnroll() {
        int courseId = getSelectedCourseId();
        if (courseId != -1) {
            enrollmentController.cancelEnrollment(courseId);
        }
    }

    public void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg, constant.Constants.DialogTitle.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, constant.Constants.DialogTitle.ERROR, JOptionPane.ERROR_MESSAGE);
    }

    public void refreshAll() {
        if (basketPane != null) basketPane.showBasket();
        if (selectPane != null) selectPane.update();
        if (searchPane != null) searchPane.update();
        if (myLecturePane != null) myLecturePane.showMy();
        if (myinfo != null) myinfo.refresh();
    }
}
