package covid.app.gui.bool.ship;


import covid.app.main.app.boolship.Labors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationFormL
        extends JFrame
        implements ActionListener {


    SpinnerNumberModel numberEmployees = new SpinnerNumberModel(
            new Integer(1), // value
            new Integer(1), // min
            new Integer(400), // max
            new Integer(1) // step
    );
    SpinnerNumberModel numberOfDepartments = new SpinnerNumberModel(
            new Integer(1), // value
            new Integer(1), // min
            new Integer(400), // max
            new Integer(1) // step
    );
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();


    private Container c = getContentPane();
    private JLabel title;

    private JLabel name;
    private JTextField tname;

    private JLabel mail;
    private JTextField tmail;

    private JLabel area;
    private JTextField tarea;

    private JSpinner numOfPeople;
    private JLabel tnumOfPeople;

    private JSpinner numOfD;
    private JLabel tnumOfD;

    private JLabel username;
    private JTextField tusername;

    private JLabel password;
    private JPasswordField tpassword;

    private JLabel rpassword;
    private JPasswordField trpassword;


    private JCheckBox term;
    private JCheckBox enclosed;
    private JButton submit;
    private JButton reset;


    // constructor, to initialize the components
    // with default values.
    public RegistrationFormL() {

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\BooleanShipProjectJ\\CovidApp\\src\\covid\\app\\gui\\bool\\ship\\covidReg3.png"));
        c.add(background);

        title = new JLabel("Labor User Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(650, 50);
        title.setLocation(200, 30);
        background.add(title);

        name = new JLabel("Organisation Name");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setSize(200, 20);
        name.setLocation(20, 100);
        background.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.BOLD, 15));
        tname.setSize(150, 20);
        tname.setLocation(200, 100);
        background.add(tname);

        numOfD = new JSpinner(numberOfDepartments);
        numOfD.setFont(new Font("Arial", Font.BOLD, 20));
        numOfD.setSize(30, 20);
        numOfD.setLocation(600, 100);
        background.add(numOfD);

        tnumOfD = new JLabel("Number of Departments");
        tnumOfD.setFont(new Font("Arial", Font.BOLD, 15));
        tnumOfD.setSize(350, 20);
        tnumOfD.setLocation(420, 100);
        background.add(tnumOfD);


        mail = new JLabel("Organisations Email");//have to include the email validation
        mail.setFont(new Font("Arial", Font.BOLD, 20));
        mail.setSize(350, 20);
        mail.setLocation(5, 150);
        background.add(mail);

        tmail = new JTextField();
        tmail.setFont(new Font("Arial", Font.BOLD, 15));
        tmail.setSize(150, 20);
        tmail.setLocation(200, 150);
        background.add(tmail);

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


        area = new JLabel("Headquarters Area");
        area.setFont(new Font("Arial", Font.BOLD, 20));
        area.setSize(200, 20);
        area.setLocation(22, 200);
        background.add(area);

        tarea = new JTextField();
        tarea.setFont(new Font("Arial", Font.BOLD, 15));
        tarea.setSize(150, 20);
        tarea.setLocation(200, 200);
        background.add(tarea);

        password = new JLabel("Set Password");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setSize(300, 20);
        password.setLocation(460, 200);
        background.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.BOLD, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(600, 200);
        background.add(tpassword);

        numOfPeople = new JSpinner(numberEmployees);
        numOfPeople.setFont(new Font("Arial", Font.BOLD, 20));
        numOfPeople.setSize(30, 20);
        numOfPeople.setLocation(225, 250);
        background.add(numOfPeople);

        tnumOfPeople = new JLabel("Number of Employees");
        tnumOfPeople.setFont(new Font("Arial", Font.BOLD, 20));
        tnumOfPeople.setSize(300, 20);
        tnumOfPeople.setLocation(15, 250);
        background.add(tnumOfPeople);

        rpassword = new JLabel("Repeat Password");
        rpassword.setFont(new Font("Arial", Font.BOLD, 20));
        rpassword.setSize(300, 20);
        rpassword.setLocation(427, 250);
        background.add(rpassword);

        trpassword = new JPasswordField();
        trpassword.setFont(new Font("Arial", Font.BOLD, 15));
        trpassword.setSize(150, 20);
        trpassword.setLocation(600, 250);
        background.add(trpassword);


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
            int numDepartment = (int) numberOfDepartments.getValue();
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
            } else if (rpassword.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Repeat Password", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should contain more than 6 characters", "Weak Password", JOptionPane.ERROR_MESSAGE);
            }else if(!GuiClass.isValidEmail(orgMail)){
                tmail.setText("");
            } else {
                usernames.add(username);
                passwords.add(password);
                Labors newOne = new Labors(orgName, orgArea, numEmployees, orgMail);
                ok = true;
            }
            if (ok) {
                dispose();
                GuiClass.alreadyUserOption("Labor Home menu log form");
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
            enclosed.setSelected(false);
            term.setSelected(false);

        }

    }
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
