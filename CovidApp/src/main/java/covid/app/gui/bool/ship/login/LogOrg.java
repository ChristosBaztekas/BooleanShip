package covid.app.gui.bool.ship.login;


import covid.app.data.dao.DaoImpl;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.gui.bool.ship.mainMenu.JavaMailUtil;
import covid.app.gui.bool.ship.menus.OrgMenu;
import covid.app.manager.DBConnectionManager;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOrg extends JFrame implements ActionListener {
    static String orgname = null;
    static String orgUsername = null;
    static String possibleOrgUsername = null;
    static int chance = 0;
    static int wrongPassword = 0;
    static String possibleOrgname = null;
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


    public LogOrg() {
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
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);

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
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            DBConnectionManager manager2 = new DBConnectionManager();
            DaoImpl impl2 = new DaoImpl(manager2);
            String userType = "Government";
            possibleOrgUsername = userText;
            possibleOrgname = impl2.findOrgname(possibleOrgUsername);
            if (!possibleOrgname.equals("") && !possibleOrgUsername.equals("")) {
                if (impl2.readUserById(userText, pwdText, userType)) {
                    JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

                    orgUsername = userText;
                    DBConnectionManager manager = new DBConnectionManager();
                    DaoImpl impl = new DaoImpl(manager);
                    orgname = impl.findOrgname(orgUsername);

                    GuiClass verification = new GuiClass();
                    JOptionPane.showMessageDialog(this, "For safety reasons and for the protection of our users data we need to verify that it you are the authorized for surveillance user.", "Data security", JOptionPane.INFORMATION_MESSAGE);
                    if (verification.validation(impl.findOrgEmailfromOrgName(orgname))) {
                        JOptionPane.showMessageDialog(this, "Redirecting to the main government menu", "Redirection", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        OrgMenu wsFrame = new OrgMenu();
                        wsFrame.setBounds(400, 100, 900, 700);
                        wsFrame.setTitle("Welcome to the main Government User Menu!");
                        wsFrame.setVisible(true);
                        wsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    } else {
                        dispose();
                        GuiClass wsFrame = new GuiClass();
                        wsFrame.setBounds(400, 100, 900, 700);
                        wsFrame.setVisible(true);
                        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
                        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                } else {
                    if (wrongPassword == 1) {
                        JOptionPane.showMessageDialog(null, "This password is not the correct for this menu.\nIf you forgot your password contact as at 6983461347.\nRedirection to main menu.", "Redirection", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        GuiClass wsFrame = new GuiClass();
                        wsFrame.setBounds(400, 100, 900, 700);
                        wsFrame.setVisible(true);
                        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
                        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        JOptionPane.showMessageDialog(this, "The password is incorrect.\nIf you forgot your password select this option!\nIf you fail again you will be redirected", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                        ++wrongPassword;
                    }
                }
            } else {
                if (chance == 1) {
                    JOptionPane.showMessageDialog(null, "This username is not the correct for this menu.\nIf you forgot your username contact as at 6983461347.\nRedirection to main menu.", "Redirection", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    GuiClass wsFrame = new GuiClass();
                    wsFrame.setBounds(400, 100, 900, 700);
                    wsFrame.setVisible(true);
                    wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
                    wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    ++chance;
                    JOptionPane.showMessageDialog(null, "This username is not the correct for this menu.\nIf you forgot your username contact as at 6983461347.\nYou have one more chance or you will be redirected to main menu.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == forgotPassword) {
            String emailF = JOptionPane.showInputDialog("Input your mail and you will get a mail immediately with more info.");
            forgotPassword.setSelected(false);
            try {

                JavaMailUtil.sendMail(emailF, "Password", "Call us on 6983461347(9:00-17:00) and after verifying your identity we will give you your new password.");
                JOptionPane.showMessageDialog(this, "Please check your mail box!", "New Mail", JOptionPane.INFORMATION_MESSAGE);
            } catch (MessagingException messagingException) {
                JOptionPane.showMessageDialog(this, "An error occurred.Check if the email address is right.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

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

    public static String getOrgname() {
        return orgname;
    }

    public static String getOrgUsername() {
        return orgUsername;
    }
}
