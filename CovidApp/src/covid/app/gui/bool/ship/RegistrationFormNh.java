package covid.app.gui.bool.ship;


import covid.app.main.app.boolship.NursingHomes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationFormNh
        extends JFrame
        implements ActionListener {

    static boolean enclosedN = false;
    SpinnerNumberModel numberEmployees = new SpinnerNumberModel(
            Integer.valueOf(1), // value
            Integer.valueOf(1), // min
            Integer.valueOf(400), // max
            Integer.valueOf(1) // step
    );
    SpinnerNumberModel numberOfElderlyResidents = new SpinnerNumberModel(
            Integer.valueOf(1), // value
            Integer.valueOf(1), // min
            Integer.valueOf(400), // max
            Integer.valueOf(1) // step
    );
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();


    private final JTextField tname;

    private final JTextField tmail;

    private final JTextField tarea;

    private final JSpinner numOfPeople;

    private final JSpinner numOfEPeople;
    private final JLabel tnumOfEPeople;

    private final JLabel username;
    private final JTextField tusername;

    private final JPasswordField tpassword;

    private final JPasswordField trpassword;


    private final JCheckBox term;
    private final JCheckBox enclosed;
    private final JButton submit;
    private final JButton reset;


    // constructor, to initialize the components
    // with default values.
    public RegistrationFormNh() {

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\BooleanShipProjectJ\\CovidApp\\src\\covid\\app\\gui\\bool\\ship\\covidReg1.jpg"));
        Container c = getContentPane();
        c.add(background);
        JLabel title = new JLabel("Nursing Home User Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(650, 50);
        title.setLocation(100, 30);
        background.add(title);

        JLabel name = new JLabel("Organisation Name");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setSize(200, 20);
        name.setLocation(20, 100);
        background.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.BOLD, 15));
        tname.setSize(150, 20);
        tname.setLocation(200, 100);
        background.add(tname);

        numOfEPeople = new JSpinner(numberOfElderlyResidents);
        numOfEPeople.setFont(new Font("Arial", Font.BOLD, 20));
        numOfEPeople.setSize(30, 20);
        numOfEPeople.setLocation(640, 100);
        background.add(numOfEPeople);

        tnumOfEPeople = new JLabel("Number of Elderly Residents");
        tnumOfEPeople.setFont(new Font("Arial", Font.BOLD, 20));
        tnumOfEPeople.setSize(350, 20);
        tnumOfEPeople.setLocation(370, 100);
        background.add(tnumOfEPeople);


        JLabel mail = new JLabel("Organisations Email");//have to include the email validation
        mail.setFont(new Font("Arial", Font.BOLD, 20));
        mail.setSize(350, 20);
        mail.setLocation(3, 150);
        background.add(mail);

        tmail = new JTextField();
        tmail.setFont(new Font("Arial", Font.BOLD, 15));
        tmail.setSize(150, 20);
        tmail.setLocation(200, 150);
        background.add(tmail);

        username = new JLabel("Set Username");
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setSize(300, 20);
        username.setLocation(420, 150);
        background.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.BOLD, 15));
        tusername.setSize(150, 20);
        tusername.setLocation(580, 150);
        background.add(tusername);


        JLabel area = new JLabel("Headquarters Area");
        area.setFont(new Font("Arial", Font.BOLD, 20));
        area.setSize(200, 20);
        area.setLocation(22, 200);
        background.add(area);

        tarea = new JTextField();
        tarea.setFont(new Font("Arial", Font.BOLD, 15));
        tarea.setSize(150, 20);
        tarea.setLocation(200, 200);
        background.add(tarea);

        JLabel password = new JLabel("Set Password");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setSize(300, 20);
        password.setLocation(420, 200);
        background.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.BOLD, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(580, 200);
        background.add(tpassword);

        numOfPeople = new JSpinner(numberEmployees);
        numOfPeople.setFont(new Font("Arial", Font.BOLD, 20));
        numOfPeople.setSize(30, 20);
        numOfPeople.setLocation(230, 250);
        background.add(numOfPeople);

        JLabel tnumOfPeople = new JLabel("Number of Employees");
        tnumOfPeople.setFont(new Font("Arial", Font.BOLD, 20));
        tnumOfPeople.setSize(300, 20);
        tnumOfPeople.setLocation(20, 250);
        background.add(tnumOfPeople);

        JLabel rpassword = new JLabel("Repeat Password");
        rpassword.setFont(new Font("Arial", Font.BOLD, 20));
        rpassword.setSize(300, 20);
        rpassword.setLocation(400, 250);
        background.add(rpassword);

        trpassword = new JPasswordField();
        trpassword.setFont(new Font("Arial", Font.BOLD, 15));
        trpassword.setSize(150, 20);
        trpassword.setLocation(580, 250);
        background.add(trpassword);


        term = new JCheckBox("Accept Terms And Conditions");
        term.setFont(new Font("Arial", Font.BOLD, 15));
        term.setSize(250, 20);
        term.setLocation(250, 322);
        background.add(term);

        enclosed = new JCheckBox("Select if Nursing Home is enclosed");
        enclosed.setFont(new Font("Arial", Font.BOLD, 15));
        enclosed.setSize(350, 20);
        enclosed.setLocation(250, 300);
        background.add(enclosed);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.setSize(100, 20);
        submit.setLocation(270, 350);
        submit.addActionListener(this);
        background.add(submit);

        tarea.setOpaque(false);
        tname.setOpaque(false);

        tmail.setOpaque(false);
        tpassword.setOpaque(false);
        trpassword.setOpaque(false);
        tusername.setOpaque(false);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        reset.setSize(100, 20);
        reset.setLocation(380, 350);
        reset.addActionListener(this);
        background.add(reset);
        reset.setOpaque(false);
        reset.setContentAreaFilled(false);
        submit.setOpaque(false);
        submit.setContentAreaFilled(false);
        term.setOpaque(false);
        term.setContentAreaFilled(false);
        enclosed.setOpaque(false);
        enclosed.setContentAreaFilled(false);

        enclosed.setForeground(Color.WHITE);
        term.setForeground(Color.WHITE);
        submit.setForeground(Color.WHITE);
        reset.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        mail.setForeground(Color.WHITE);
        area.setForeground(Color.WHITE);
        tnumOfPeople.setForeground(Color.WHITE);
        tnumOfEPeople.setForeground(Color.WHITE);

        username.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        rpassword.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            String orgName = tname.getText();
            String orgMail = tmail.getText();
            String orgArea = tarea.getText();


            int numEmployees = (int) numOfEPeople.getValue();
            int numElderly = (int) numOfPeople.getValue();
            String username = tusername.getText();
            String password = tpassword.getText();
            String rpassword = trpassword.getText();
            enclosedN = enclosed.isSelected();
            if (!term.isSelected()) {
                JOptionPane.showMessageDialog(null, "You have to accept the terms before registering", "Term Field", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(rpassword)) {
                JOptionPane.showMessageDialog(null, "The passwords are not the same", "Password", JOptionPane.ERROR_MESSAGE);
            } else if (orgName.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Name", JOptionPane.ERROR_MESSAGE);
            } else if (orgMail.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Email", JOptionPane.ERROR_MESSAGE);
            } else if (orgArea.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Area", JOptionPane.ERROR_MESSAGE);
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Password", JOptionPane.ERROR_MESSAGE);
            } else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should contain more than 6 characters", "Weak Password", JOptionPane.ERROR_MESSAGE);
            } else if (!GuiClass.isValidEmail(orgMail)) {
                tmail.setText("");
            } else {

                usernames.add(username);
                passwords.add(password);
                NursingHomes newOne = new NursingHomes(orgName, orgArea, (numElderly + numEmployees), orgMail, enclosedN);
                // try {
                //   JavaMailUtil.sendMail(orgMail,"Welcome","Thank you for registering on our app.If you have any problem feel free to contact us. ");
                //} catch (MessagingException messagingException) {
                //  JOptionPane.showMessageDialog(null, "An error occurred please check if your connection is good and if your email is right.", "Error", JOptionPane.ERROR_MESSAGE);
                //}
                dispose();
                GuiClass.alreadyUserOption("Nursing Home menu log form");
            }

        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tarea.setText(def);
            tmail.setText(def);
            tpassword.setText(def);
            trpassword.setText(def);
            username.setText(def);
            tnumOfEPeople.setText(def);
            tnumOfEPeople.setText(def);
            enclosed.setSelected(false);
            term.setSelected(false);

        }

    }
}
