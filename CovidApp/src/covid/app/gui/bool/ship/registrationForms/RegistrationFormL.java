package covid.app.gui.bool.ship.registrationForms;


import covid.app.data.dao.UserDaoImpl;
import covid.app.data.model.User;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.main.app.boolship.Labors;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationFormL
        extends JFrame
        implements ActionListener {


    SpinnerNumberModel numberEmployees = new SpinnerNumberModel(
            Integer.valueOf(1), // value
            Integer.valueOf(1), // min
            Integer.valueOf(400), // max
            Integer.valueOf(1) // step
    );
    SpinnerNumberModel numberOfDepartments = new SpinnerNumberModel(
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

    private final JLabel username;
    private final JTextField tusername;

    private final JPasswordField tpassword;

    private final JPasswordField trpassword;


    private final JCheckBox term;
    private final JButton submit;
    private final JButton reset;



    public RegistrationFormL() {
        Color col = new Color(255, 255, 255);
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\BooleanShipProjectJ\\CovidApp\\src\\covid\\app\\gui\\bool\\ship\\covidReg3.png"));
        Container c = getContentPane();
        c.add(background);

        JLabel title = new JLabel("Labor User Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(650, 50);
        title.setLocation(200, 30);
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
        tname.setForeground(col);
        JSpinner numOfD = new JSpinner(numberOfDepartments);
        numOfD.setFont(new Font("Arial", Font.BOLD, 20));
        numOfD.setSize(30, 20);
        numOfD.setLocation(600, 100);
        background.add(numOfD);

        JLabel tnumOfD = new JLabel("Number of Departments");
        tnumOfD.setFont(new Font("Arial", Font.BOLD, 15));
        tnumOfD.setSize(350, 20);
        tnumOfD.setLocation(420, 100);
        background.add(tnumOfD);


        JLabel mail = new JLabel("Organisations Email");//have to include the email validation
        mail.setFont(new Font("Arial", Font.BOLD, 20));
        mail.setSize(350, 20);
        mail.setLocation(5, 150);
        background.add(mail);

        tmail = new JTextField();
        tmail.setFont(new Font("Arial", Font.BOLD, 15));
        tmail.setSize(150, 20);
        tmail.setLocation(200, 150);
        background.add(tmail);
        tmail.setForeground(col);
        username = new JLabel("Set Username");
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setSize(300, 20);
        username.setLocation(460, 150);
        background.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.BOLD, 15));
        tusername.setSize(150, 20);
        tusername.setLocation(600, 150);
        background.add(tusername);
        tusername.setForeground(col);

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
        tarea.setForeground(col);
        JLabel password = new JLabel("Set Password");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setSize(300, 20);
        password.setLocation(460, 200);
        background.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.BOLD, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(600, 200);
        background.add(tpassword);
        tpassword.setForeground(col);
        numOfPeople = new JSpinner(numberEmployees);
        numOfPeople.setFont(new Font("Arial", Font.BOLD, 20));
        numOfPeople.setSize(30, 20);
        numOfPeople.setLocation(225, 250);
        background.add(numOfPeople);

        JLabel tnumOfPeople = new JLabel("Number of Employees");
        tnumOfPeople.setFont(new Font("Arial", Font.BOLD, 20));
        tnumOfPeople.setSize(300, 20);
        tnumOfPeople.setLocation(15, 250);
        background.add(tnumOfPeople);

        JLabel rpassword = new JLabel("Repeat Password");
        rpassword.setFont(new Font("Arial", Font.BOLD, 20));
        rpassword.setSize(300, 20);
        rpassword.setLocation(427, 250);
        background.add(rpassword);

        trpassword = new JPasswordField();
        trpassword.setFont(new Font("Arial", Font.BOLD, 15));
        trpassword.setSize(150, 20);
        trpassword.setLocation(600, 250);
        background.add(trpassword);
        trpassword.setForeground(col);

        term = new JCheckBox("Accept Terms And Conditions");
        term.setFont(new Font("Arial", Font.BOLD, 15));
        term.setSize(250, 20);
        term.setLocation(300, 322);
        background.add(term);


        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.setSize(100, 20);
        submit.setLocation(300, 350);
        submit.addActionListener(this);
        background.add(submit);


        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        reset.setSize(100, 20);
        reset.setLocation(420, 350);
        reset.addActionListener(this);
        background.add(reset);


        term.setForeground(Color.WHITE);

        submit.setForeground(Color.WHITE);

        reset.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);
        name.setForeground(Color.WHITE);
        mail.setForeground(Color.WHITE);
        area.setForeground(Color.WHITE);
        username.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        rpassword.setForeground(Color.WHITE);
        tnumOfPeople.setForeground(Color.WHITE);
        tnumOfD.setForeground(Color.WHITE);


        reset.setContentAreaFilled(false);
        submit.setOpaque(false);
        submit.setContentAreaFilled(false);
        term.setOpaque(false);
        term.setContentAreaFilled(false);
        tarea.setOpaque(false);
        tname.setOpaque(false);
        tmail.setOpaque(false);
        tpassword.setOpaque(false);
        trpassword.setOpaque(false);
        tusername.setOpaque(false);
        reset.setOpaque(false);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            boolean ok = false;
            String orgName = tname.getText();
            String orgMail = tmail.getText();
            String orgArea = tarea.getText();
            //int numDepartment = (int) numberOfDepartments.getValue();
            int numEmployees = (int) numOfPeople.getValue();
            String username = tusername.getText();
            String password = tpassword.getText();
            String rpassword = trpassword.getText();

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
            }   else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should contain more than 6 characters", "Weak Password", JOptionPane.ERROR_MESSAGE);
            } else if (!GuiClass.isValidEmail(orgMail)) {
                tmail.setText("");
            } else {

                String activity = "The situation for labors is unstable";
                Labors newOne = new Labors(orgName, orgArea, numEmployees, orgMail);
                User leonidas = new User("", password, orgMail, username, "Labor");
                DBConnectionManager manager = new DBConnectionManager();
                UserDaoImpl impl = new UserDaoImpl(manager);
                impl.insertUser(leonidas);
                DBConnectionManager manager2 = new DBConnectionManager();
                UserDaoImpl impl2 = new UserDaoImpl(manager2);
                impl2.insertOrganisation("", "Labor", orgName, orgArea, numEmployees, username, activity);
                JOptionPane.showMessageDialog(this, "Thank you for registering", "Account created", JOptionPane.INFORMATION_MESSAGE);
                GuiClass.registrationAutomatedMail(orgMail);
                ok = true;
            }
            if (ok) {
                dispose();
                GuiClass.alreadyUserOptionL("Labor Home menu log form");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tarea.setText(def);
            tmail.setText(def);
            tpassword.setText(def);
            trpassword.setText(def);
            username.setText(def);
            numOfPeople.setValue(1);
            numberOfDepartments.setValue(1);

            term.setSelected(false);

        }

    }
}

