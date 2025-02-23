package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Constant.constant.login;
import Control.Control;

public class LoginFrame extends JFrame {
    private static final long serialVersionUID = login.VERSION_NUM;

    private JLabel idLb, pwLb, image;
    private JPanel loginPanel, backPanel;
    private JTextField idField;
    private JPasswordField pwField;
    private JButton loginBtn;
    private ActionListener actionListener;

    public LoginFrame() {
        this.setSize(login.WIDTH, login.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(login.TITLE);

        actionListener = new ActionHandler();
        
        // Login panel
        loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(login.LOGIN_PANEL_WIDTH, login.HEIGHT));
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Logo image
        ImageIcon logo = new ImageIcon(login.IMAGE_PATH);
        Image imge = logo.getImage(); 
        Image newImg = imge.getScaledInstance(200, 60, Image.SCALE_SMOOTH); 
        ImageIcon newLogo = new ImageIcon(newImg); 
        image = new JLabel(newLogo); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(image, gbc);
        
        // ID label and field
        idLb = new JLabel(login.IDFIELD);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(idLb, gbc);
        
        idField = new JTextField(login.ID_FIELD_LENGTH);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(idField, gbc);

        // Password label and field
        pwLb = new JLabel(login.PWFIELD);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(pwLb, gbc);

        pwField = new JPasswordField(login.PW_FIELD_LENGTH);
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(pwField, gbc);

        // Login button
        loginBtn = new JButton(login.BT);
        loginBtn.setActionCommand(login.BT);
        loginBtn.addActionListener(actionListener);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(loginBtn, gbc);

        // Background panel
        backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(login.IMAGE_PANEL_WIDTH, login.HEIGHT));
        backPanel.setLayout(null);

        // Background image
        ImageIcon backgroundImage = new ImageIcon(login.BACKIMAGE_PATH);
        Image backgroundImg = backgroundImage.getImage().getScaledInstance(login.IMAGE_PANEL_WIDTH, login.HEIGHT, Image.SCALE_SMOOTH);
        JLabel backLabel = new JLabel(new ImageIcon(backgroundImg));
        backLabel.setBounds(0, 0, login.IMAGE_PANEL_WIDTH, login.HEIGHT);
        backPanel.add(backLabel);

        // Add panels to frame
        this.setLayout(new BorderLayout());
        this.add(loginPanel, BorderLayout.WEST);
        this.add(backPanel, BorderLayout.CENTER);
    }

    public void LoginSuccess() throws HeadlessException {
    }

    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(login.BT)) {
                int id = Integer.parseInt(idField.getText());
                char[] ps = pwField.getPassword();
                Control ctrl = new Control();
                
                // Login result
                if (ctrl.IsID(id) && ctrl.IsPw(ps)) {
                    JOptionPane.showMessageDialog(null, "로그인 성공", login.SUCCESS_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                    ctrl.setUserId(id);
                    dispose();
                    Vmainframe vMainFrame = new Vmainframe();
                    vMainFrame.setVisible(true);
                } else if (ctrl.IsID(id)) {
                    JOptionPane.showMessageDialog(null, "비밀번호 오류", login.WRONG_PW_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "존재하지 않는 ID입니다", login.NONE_ID_PW_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public void initialize() {
    }
}
