package view;

import java.awt.*;
import javax.swing.*;

import constant.Constants.login;
import controller.LoginController;

public class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private LoginController controller;

    private JLabel idLb, pwLb, image;
    private JPanel loginPanel, backPanel;
    private JTextField idField;
    private JPasswordField pwField;
    private JButton loginBtn;

    public LoginFrame() {
        this.controller = new LoginController(this);

        this.setSize(login.WIDTH, login.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(login.TITLE);

        loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(login.LOGIN_PANEL_WIDTH, login.HEIGHT));
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ImageIcon logo = new ImageIcon(login.IMAGE_PATH);
        Image imge = logo.getImage();
        Image newImg = imge.getScaledInstance(200, 60, Image.SCALE_SMOOTH);
        ImageIcon newLogo = new ImageIcon(newImg);
        image = new JLabel(newLogo);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(image, gbc);

        idLb = new JLabel(login.IDFIELD);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(idLb, gbc);

        idField = new JTextField(login.ID_FIELD_LENGTH);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(idField, gbc);

        pwLb = new JLabel(login.PWFIELD);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(pwLb, gbc);

        pwField = new JPasswordField(login.PW_FIELD_LENGTH);
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(pwField, gbc);

        loginBtn = new JButton(login.BT);
        loginBtn.addActionListener(e -> handleLogin());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(loginBtn, gbc);

        backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(login.IMAGE_PANEL_WIDTH, login.HEIGHT));
        backPanel.setLayout(null);

        ImageIcon backgroundImage = new ImageIcon(login.BACKIMAGE_PATH);
        Image backgroundImg = backgroundImage.getImage().getScaledInstance(login.IMAGE_PANEL_WIDTH, login.HEIGHT, Image.SCALE_SMOOTH);
        JLabel backLabel = new JLabel(new ImageIcon(backgroundImg));
        backLabel.setBounds(0, 0, login.IMAGE_PANEL_WIDTH, login.HEIGHT);
        backPanel.add(backLabel);

        this.setLayout(new BorderLayout());
        this.add(loginPanel, BorderLayout.WEST);
        this.add(backPanel, BorderLayout.CENTER);
    }

    private void handleLogin() {
        try {
            int id = Integer.parseInt(idField.getText());
            char[] pw = pwField.getPassword();
            controller.login(id, pw);
        } catch (NumberFormatException ex) {
            showError(constant.Constants.ErrorMessage.ID_MUST_BE_NUMBER);
        }
    }

    public void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg, constant.Constants.DialogTitle.SUCCESS, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, constant.Constants.DialogTitle.ERROR, JOptionPane.ERROR_MESSAGE);
    }

    public void showMainFrame() {
        dispose();
        new VMainFrame().setVisible(true);
    }
}
