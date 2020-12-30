package CovidApp.Gui.BooleanShip;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LogOrg extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
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


    LogOrg() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        forgotPassword.setBounds(5, 250, 150, 30);
        loginButton.setBounds(20, 300, 100, 30);
        resetButton.setBounds(120, 300, 100, 30);
        exit.setBounds(220, 300, 120, 30);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(forgotPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(exit);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        forgotPassword.addActionListener(this);
        exit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("LeonidasDiamg") && pwdText.equalsIgnoreCase("fixBugs")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                JOptionPane.showMessageDialog(this, "Redirecting to the main goverment menu");
                dispose();
                OrgMenu wsFrame = new OrgMenu();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setTitle("Welcome to the main Goverment User Menu!");
                wsFrame.setVisible(true);
                wsFrame.setDefaultCloseOperation(3);
            } else if (userText.equalsIgnoreCase("LeonidasDiams") && pwdText.equalsIgnoreCase("fixBugs")){
                JOptionPane.showMessageDialog(this, "Login Successful");
                JOptionPane.showMessageDialog(this, "Redirecting to the main School menu");
                dispose();
                SchoolMenu wsFrame = new SchoolMenu();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setTitle("Welcome to the main School user menu!");
                wsFrame.setVisible(true);
                wsFrame.setDefaultCloseOperation(3);
            }else if (userText.equalsIgnoreCase("LeonidasDiaml") && pwdText.equalsIgnoreCase("fixBugs")){
                JOptionPane.showMessageDialog(this, "Login Successful");
                JOptionPane.showMessageDialog(this, "Redirecting to the main Labor menu");
                dispose();
                LaborMenu wsFrame = new LaborMenu();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setTitle("Welcome to the main Labor user menu!");
                wsFrame.setVisible(true);
                wsFrame.setDefaultCloseOperation(3);
            }else if (userText.equalsIgnoreCase("LeonidasDiamu") && pwdText.equalsIgnoreCase("fixBugs")){
                JOptionPane.showMessageDialog(this, "Login Successful");
                JOptionPane.showMessageDialog(this, "Redirecting to the main university menu");
                dispose();
                UniversityMenu wsFrame = new UniversityMenu();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setTitle("Welcome to the main University user menu!");
                wsFrame.setVisible(true);
                wsFrame.setDefaultCloseOperation(3);
            }else if (userText.equalsIgnoreCase("LeonidasDiamn") && pwdText.equalsIgnoreCase("fixBugs")){
                JOptionPane.showMessageDialog(this, "Login Successful");
                JOptionPane.showMessageDialog(this, "Redirecting to the main Nursing Home menu");
                dispose();
                NursingHomeMenu wsFrame = new NursingHomeMenu();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setTitle("Welcome to the main nursing home user menu!");
                wsFrame.setVisible(true);
                wsFrame.setDefaultCloseOperation(3);
            } else {
                JOptionPane.showMessageDialog(this, "The password is incorrect.If you forgot your password select this option!");

            }


        }
        if(e.getSource() == forgotPassword){
            String emailF = (String)JOptionPane.showInputDialog("Input your mail and you will get a mail immediately with more info.");
            forgotPassword.setSelected(false);
            try {
                JavaMailUtil.sendMail(emailF,"Password","Call us on 6983461347(9:00-17:00) and after verifying your identity we will give you your new password.");
            } catch (MessagingException messagingException) {
                JOptionPane.showMessageDialog(this, "An error occurred.Check if the email address is right.");
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
        if(e.getSource() == exit){
            try {
                d.browse(new URI(
                        "https://www.surveymonkey.com/r/2WKC6MB"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        }


    }

}
