package covid.app.gui.bool.ship.registrationForms;


import covid.app.data.dao.DaoImpl;
import covid.app.data.model.Universities;
import covid.app.data.model.User;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationFormU
        extends JFrame
        implements ActionListener {


    SpinnerNumberModel numberP = new SpinnerNumberModel(
            Integer.valueOf(1), // value
            Integer.valueOf(1), // min
            Integer.valueOf(400), // max
            Integer.valueOf(1) // step
    );
    SpinnerNumberModel numberS = new SpinnerNumberModel(
            Integer.valueOf(1), // value
            Integer.valueOf(1), // min
            Integer.valueOf(400), // max
            Integer.valueOf(1) // step
    );


    private final JTextField tname;

    private final JTextField tmail;

    private final JTextField tarea;

    private final JSpinner numP;

    private final JSpinner numS;

    private final JLabel username;
    private final JTextField tusername;

    private final JPasswordField tpassword;

    private final JPasswordField trpassword;


    private final JCheckBox term;
    private final JButton submit;
    private final JButton reset;


    // constructor, to initialize the components
    // with default values.
    public RegistrationFormU() {
        Color col = new Color(255, 255, 255);
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\BooleanShipProjectJ\\CovidApp\\src\\covid\\app\\gui\\bool\\ship\\regi2.png"));
        Container c = getContentPane();
        c.add(background);

        JLabel title = new JLabel("University User Registration Form");
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
        tname.setForeground(col);

        numS = new JSpinner(numberS);
        numS.setFont(new Font("Arial", Font.BOLD, 20));
        numS.setSize(30, 20);
        numS.setLocation(600, 100);
        background.add(numS);

        JLabel tnumS = new JLabel("Number of Students");
        tnumS.setFont(new Font("Arial", Font.BOLD, 20));
        tnumS.setSize(350, 20);
        tnumS.setLocation(410, 100);
        background.add(tnumS);


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
        username.setLocation(465, 150);
        background.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.BOLD, 15));
        tusername.setSize(150, 20);
        tusername.setLocation(600, 150);
        background.add(tusername);
        tusername.setForeground(col);

        JLabel area = new JLabel("University's Area");
        area.setFont(new Font("Arial", Font.BOLD, 20));
        area.setSize(200, 20);
        area.setLocation(24, 200);
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
        password.setLocation(465, 200);
        background.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.BOLD, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(600, 200);
        background.add(tpassword);
        tpassword.setForeground(col);
        numP = new JSpinner(numberP);
        numP.setFont(new Font("Arial", Font.BOLD, 20));
        numP.setSize(30, 20);
        numP.setLocation(225, 250);
        background.add(numP);

        JLabel tnumP = new JLabel("Number of Professors");
        tnumP.setFont(new Font("Arial", Font.BOLD, 20));
        tnumP.setSize(300, 20);
        tnumP.setLocation(10, 250);
        background.add(tnumP);

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
        tnumS.setForeground(Color.WHITE);
        tnumP.setForeground(Color.WHITE);


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
            GuiClass verification = new GuiClass();
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            boolean ok = false;
            String orgName = tname.getText();
            String orgMail = tmail.getText();
            String orgArea = tarea.getText();
            int numPr = (int) numP.getValue();
            int numSt = (int) numS.getValue();
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
            } else if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "This section can not be empty", "Organisation Username", JOptionPane.ERROR_MESSAGE);
            } else if (rpassword.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should contain more than 6 characters", "Weak Password", JOptionPane.ERROR_MESSAGE);
            } else if (!GuiClass.isValidEmail(orgMail)) {
                tmail.setText("");
            } else if (impl.usernameExists(username)) {
                JOptionPane.showMessageDialog(null, "Username already exists.Please choose another username", "Username exists", JOptionPane.ERROR_MESSAGE);
            } else if (impl.emailExists(orgMail)) {
                JOptionPane.showMessageDialog(null, "Already an account with this email exists.If you forgot your password choose the current option from the user form.", "Email exists", JOptionPane.ERROR_MESSAGE);
            } else if (!verification.registrationCode(orgMail)) {
                dispose();
                GuiClass wsFrame = new GuiClass();
                wsFrame.setBounds(400, 100, 900, 700);
                wsFrame.setVisible(true);
                wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
                wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            } else {
                String activity = "Universities are using distance education";
                Universities u = new Universities(orgName, orgArea, (numPr + numSt), orgMail);
                User leonidas = new User("", password, orgMail, username, "University");
                impl.insertUser(leonidas);
                DBConnectionManager manager2 = new DBConnectionManager();
                DaoImpl impl2 = new DaoImpl(manager2);
                impl2.insertOrganisation("", "University", orgName, orgArea, (numPr + numSt), username, activity);

                JOptionPane.showMessageDialog(this, "Thank you for registering", "Account created", JOptionPane.INFORMATION_MESSAGE);
                GuiClass.registrationAutomatedMail(orgMail);
                ok = true;
            }
            if (ok) {
                dispose();
                GuiClass.alreadyUserOptionU("University menu log form");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tarea.setText(def);
            tmail.setText(def);
            tpassword.setText(def);
            trpassword.setText(def);
            username.setText(def);
            numP.setValue(1);
            numS.setValue(1);

            term.setSelected(false);

        }

    }
}

