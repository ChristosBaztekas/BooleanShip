package covid.app.gui.bool.ship.login;

import covid.app.data.dao.UserDaoImpl;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.gui.bool.ship.mainMenu.JavaMailUtil;
import covid.app.gui.bool.ship.menus.OrgMenu;
import covid.app.gui.bool.ship.menus.UniversityMenu;
import covid.app.manager.DBConnectionManager;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogUniversity extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JCheckBox forgotPassword = new JCheckBox("Forgot Password");
    JButton exit = new JButton("Exit Program");


    public LogUniversity() {
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\log1.png"));
        container.add(background);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(190, 250, 150, 30);
        forgotPassword.setBounds(40, 250, 150, 30);
        loginButton.setBounds(20, 300, 100, 30);
        resetButton.setBounds(120, 300, 100, 30);
        exit.setBounds(220, 300, 120, 30);
        userLabel.setFont(new Font("Serif", Font.BOLD, 17));
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 17));
        forgotPassword.setFont(new Font("Serif", Font.BOLD, 14));
        showPassword.setFont(new Font("Serif", Font.BOLD, 14));
        loginButton.setFont(new Font("Serif", Font.BOLD, 14));
        resetButton.setFont(new Font("Serif", Font.BOLD, 14));
        exit.setFont(new Font("Serif", Font.BOLD, 14));
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        //loginButton.setBorderPainted(false);
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false);
        //resetButton.setBorderPainted(false);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        //exit.setBorderPainted(false);

        background.add(userLabel);
        background.add(passwordLabel);
        background.add(userTextField);
        background.add(passwordField);
        background.add(showPassword);
        background.add(forgotPassword);
        background.add(loginButton);
        background.add(resetButton);
        background.add(exit);

        userLabel.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.BLACK);
        showPassword.setForeground(Color.BLACK);
        showPassword.setForeground(Color.BLACK);
        forgotPassword.setForeground(Color.BLACK);
        loginButton.setForeground(Color.BLACK);
        resetButton.setForeground(Color.BLACK);
        exit.setForeground(Color.BLACK);

        userTextField.setOpaque(false);
        passwordField.setOpaque(false);

        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        forgotPassword.addActionListener(this);
        exit.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding
        // Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            DBConnectionManager manager2 = new DBConnectionManager();
            UserDaoImpl impl2 = new UserDaoImpl(manager2);
            String userType = "University";
            if (impl2.readUserById(userText, pwdText, userType)) {
                JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Redirecting to the main University menu", "Redirection", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                UniversityMenu wsFrame = new UniversityMenu();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setTitle("Welcome to the main University User Menu!");
                wsFrame.setVisible(true);
                wsFrame.setDefaultCloseOperation(3);
            } else {
                JOptionPane.showMessageDialog(this, "The password is incorrect.If you forgot your password select this option!", "Wrong Password", JOptionPane.ERROR_MESSAGE);
            }


        }
        if (e.getSource() == forgotPassword) {
            String emailF = (String) JOptionPane.showInputDialog("Input your mail and you will get a mail immediately with more info.");
            forgotPassword.setSelected(false);
            try {

                JavaMailUtil.sendMail(emailF, "Password", "Call us on 6983461347(9:00-17:00) and after verifying your identity we will give you your new password.");
                JOptionPane.showMessageDialog(this, "Please check your mail box!", "New Mail", JOptionPane.INFORMATION_MESSAGE);
            } catch (MessagingException messagingException) {
                JOptionPane.showMessageDialog(this, "An error occurred.Check if the email address is right.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
        if (e.getSource() == exit) {
            GuiClass.exitMethod();
        }


    }

}
