package covid.app.gui.bool.ship;

import CovidApp.Gui.BooleanShip.GuiClass;
import covid.app.main.app.boolship.Human;
import covid.app.main.app.boolship.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegistrationFormNh
        extends JFrame
        implements ActionListener {
    static boolean enclosedN = false;
    SpinnerNumberModel numberEmployees = new SpinnerNumberModel(
            new Integer(1), // value
            new Integer(1), // min
            new Integer(400), // max
            new Integer(1) // step
    );
    SpinnerNumberModel numberOfElderlyResidents = new SpinnerNumberModel(
            new Integer(1), // value
            new Integer(1), // min
            new Integer(400), // max
            new Integer(1) // step
    );

    ArrayList<Human> usersList = new ArrayList<>();
    private Container c;
    private JLabel title;

    private JLabel name;
    private JTextField tname;

    private JLabel mail;
    private JTextField tmail;

    private JLabel area;
    private JTextField tarea;

    private JSpinner numOfPeople;
    private JLabel tnumOfPeople;

    private JSpinner numOfEPeople;
    private JLabel tnumOfEPeople;

    private JLabel username;
    private JTextField tusername;

    private JLabel password;
    private JPasswordField tpassword;

    private JLabel rpassword;
    private JPasswordField trpassword;

    private JCheckBox showP;
    private JCheckBox term;
    private JCheckBox enclosed;
    private JButton submit;
    private JButton reset;


    // constructor, to initialize the components
    // with default values.
    public RegistrationFormNh() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Nursing Home User Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(550, 50);
        title.setLocation(200, 30);
        c.add(title);

        name = new JLabel("Organisation Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(200, 20);
        name.setLocation(20, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(150, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        numOfEPeople = new JSpinner(numberOfElderlyResidents);
        numOfEPeople.setFont(new Font("Arial", Font.PLAIN, 20));
        numOfEPeople.setSize(50, 20);
        numOfEPeople.setLocation(600, 100);
        c.add(numOfEPeople);

        tnumOfEPeople = new JLabel("Number of Elderly Residents");
        tnumOfEPeople.setFont(new Font("Arial", Font.PLAIN, 15));
        tnumOfEPeople.setSize(350, 20);
        tnumOfEPeople.setLocation(400, 100);
        c.add(tnumOfEPeople);


        mail = new JLabel("Organisations Email");//have to include the email validation
        mail.setFont(new Font("Arial", Font.PLAIN, 20));
        mail.setSize(350, 20);
        mail.setLocation(15, 150);
        c.add(mail);

        tmail = new JTextField();
        tmail.setFont(new Font("Arial", Font.PLAIN, 15));
        tmail.setSize(150, 20);
        tmail.setLocation(200, 150);
        c.add(tmail);

        username = new JLabel("Set Username");
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        username.setSize(300, 20);
        username.setLocation(470, 150);
        c.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.PLAIN, 15));
        tusername.setSize(150, 20);
        tusername.setLocation(600, 150);
        c.add(tusername);


        area = new JLabel("Headquarters Area");
        area.setFont(new Font("Arial", Font.PLAIN, 20));
        area.setSize(200, 20);
        area.setLocation(22, 200);
        c.add(area);

        tarea = new JTextField();
        tarea.setFont(new Font("Arial", Font.PLAIN, 15));
        tarea.setSize(150, 20);
        tarea.setLocation(200, 200);
        c.add(tarea);

        password = new JLabel("Set Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(300, 20);
        password.setLocation(470, 200);
        c.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(600, 200);
        c.add(tpassword);

        numOfPeople = new JSpinner(numberEmployees);
        numOfPeople.setFont(new Font("Arial", Font.PLAIN, 20));
        numOfPeople.setSize(50, 20);
        numOfPeople.setLocation(225, 250);
        c.add(numOfPeople);

        tnumOfPeople = new JLabel("Number of Employees");
        tnumOfPeople.setFont(new Font("Arial", Font.PLAIN, 20));
        tnumOfPeople.setSize(300, 20);
        tnumOfPeople.setLocation(20, 250);
        c.add(tnumOfPeople);

        rpassword = new JLabel("Repeat Password");
        rpassword.setFont(new Font("Arial", Font.PLAIN, 20));
        rpassword.setSize(300, 20);
        rpassword.setLocation(437, 250);
        c.add(rpassword);

        trpassword = new JPasswordField();
        trpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        trpassword.setSize(150, 20);
        trpassword.setLocation(600, 250);
        c.add(trpassword);


        term = new JCheckBox("Accept Terms And Conditions");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(300, 322);
        c.add(term);

        enclosed = new JCheckBox("Select if Nursing Home is enclosed");
        enclosed.setFont(new Font("Arial", Font.PLAIN, 15));
        enclosed.setSize(350, 20);
        enclosed.setLocation(300, 300);
        c.add(enclosed);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(300, 350);
        submit.addActionListener(this);
        c.add(submit);


        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(420, 350);
        reset.addActionListener(this);
        c.add(reset);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String orgName = tname.getText();
            String orgMail = tmail.getText();
            String orgArea = tarea.getText();
            GuiClass.isValidEmail(orgMail);
            int numEmployees = (int) numOfEPeople.getValue();
            int numElderly = (int) numOfPeople.getValue();
            String username = tusername.getText();
            String password = tpassword.getText();
            String rpassword = trpassword.getText();
            
            //insert values to DB
            String query = "insert into Org(orgName, orgMail, orgArea, numEmployees, numElderly, username, password, rpassword)values(?,?,?,?,?,?,?,?)";
            // we have to create DB Org with this values otherwise we have to do with another way
            
            try {
            	PreparedStatement pst = Main.connection.prepareStatement(query);
                pst.setString(1, orgName);
                pst.setString(2, orgMail);
                pst.setString(3, orgArea);
                pst.setInt(4, numEmployees);
				pst.setInt(5, numElderly);
				pst.setString(6, username);
	            pst.setString(7, password);
	            pst.setString(8, rpassword);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
            //if we want to show the username or whatever we use 
            //Statement st1 = Main.connection.createStatement();
            /*String query1 ="SELECT * FROM Org";
            try {
				Statement st = Main.connection.createStatement();
				ResultSet rs = st.executeQuery(query1);
				Human human;
				human = new human(rs.getString(orgName));
				and continue with the same way to get what you want
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
            */
            if (enclosed.isSelected()) {
                enclosedN = true;
            } else {
                enclosedN = false;
            }
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
            } else if (rpassword.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Repeat Password", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should contain more than 6 characters", "Weak Password", JOptionPane.ERROR_MESSAGE);
            } else {
                //NursingHomes newOne = new NursingHomes(orgName, orgArea, (numElderly + numEmployees), orgMail, enclosedN);
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