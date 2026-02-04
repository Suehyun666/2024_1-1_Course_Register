package controller;

import model.MStudent;
import view.VMainFrame;

public class MainController {
    private VMainFrame view;

    public MainController(VMainFrame view) {
        this.view = view;
    }

    public void logout() {
        try {
            MStudent.logout();
            view.showLoginFrame();
        } catch (Exception e) {
            view.showError(e.getMessage());
        }
    }
}
