package view.panel;

import javax.swing.*;

import constant.Constants.myinfo;
import model.MStudent;

public class MyInfoPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel userNameLabel;
    private JLabel userScoreLabel;

    public MyInfoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.userNameLabel = new JLabel(myinfo.NAME);
        this.userScoreLabel = new JLabel(myinfo.SCORE);

        this.add(userNameLabel);
        this.add(userScoreLabel);

        refresh();
    }

    public void refresh() {
        MStudent student = MStudent.getCurrentStudent();
        if (student != null) {
            this.userNameLabel.setText(myinfo.NAME + student.getName() + myinfo.BLAMK);
            this.userScoreLabel.setText(myinfo.SCORE + student.getEnrolledCredits() + myinfo.SLASH + student.getMaxCredits());
        }
    }
}
