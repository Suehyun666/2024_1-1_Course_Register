package view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import constant.Constants.mainframe;
import controller.MainController;
import view.panel.MyInfoPanel;
import view.panel.VMainPanel;

public class VMainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private MainController controller;

    private MyInfoPanel myinfo;
    private VMainPanel mainPanel;

    public VMainFrame() {
        this.controller = new MainController(this);

        this.setTitle(mainframe.TITLE);
        this.setSize(mainframe.Width, mainframe.Height);
        this.setLocation(mainframe.x, mainframe.y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.myinfo = new MyInfoPanel();
        this.myinfo.setPreferredSize(new Dimension(1000, 40));
        this.myinfo.setVisible(true);
        this.add(this.myinfo);

        this.mainPanel = new VMainPanel();
        this.mainPanel.setVisible(true);
        this.add(this.mainPanel);

        JButton logoutBtn = new JButton(mainframe.LOGOUT);
        logoutBtn.addActionListener(e -> controller.logout());
        this.myinfo.add(logoutBtn);

        this.mainPanel.setInfoPanel(this.myinfo);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, constant.Constants.DialogTitle.ERROR, JOptionPane.ERROR_MESSAGE);
    }

    public void showLoginFrame() {
        dispose();
        new LoginFrame().setVisible(true);
    }
}
