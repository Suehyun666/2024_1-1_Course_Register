package controller;

import model.MStudent;
import view.LoginFrame;
import constant.Constants;

public class LoginController {
    private LoginFrame view;

    public LoginController(LoginFrame view) {
        this.view = view;
    }

    public void login(int studentId, char[] password) {
        try {
            MStudent student = MStudent.login(studentId, password);
            if (student == null) {
                throw new Exception(Constants.ErrorMessage.INVALID_ID_PW);
            }
            view.showSuccess(Constants.Message.LOGIN_SUCCESS);
            view.showMainFrame();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }
}
