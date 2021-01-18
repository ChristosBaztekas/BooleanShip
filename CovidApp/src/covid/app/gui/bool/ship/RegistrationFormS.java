package covid.app.gui.bool.ship;


import covid.app.main.app.boolship.Universities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrationFormS
        extends JFrame
        implements ActionListener {

    SpinnerNumberModel numberT = new SpinnerNumberModel(
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
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();


    private final JTextField tname;

    private final JTextField tmail;

    private final JTextField tarea;

    private final JSpinner numT;

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
    public RegistrationFormS() {

        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\BooleanShipProjectJ\\CovidApp\\src\\covid\\app\\gui\\bool\\ship\\regi2.png"));
        Container c = getContentPane();
        c.add(background);

        JLabel title = new JLabel("School User Registration Form");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setSize(650, 50);
        title.setLocation(196, 30);
        title.setForeground(Color.WHITE);
        background.add(title);

        JLabel name = new JLabel("Organisation Name");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setSize(200, 30);
        name.setLocation(15, 96);
        name.setForeground(Color.WHITE);
        background.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.BOLD, 15));
        tname.setSize(150, 20);
        tname.setLocation(200, 100);
        background.add(tname);

        numS = new JSpinner(numberS);
        numS.setFont(new Font("Arial", Font.BOLD, 20));
        numS.setSize(30, 20);
        numS.setLocation(600, 100);
        background.add(numS);

        JLabel tnumS = new JLabel("Number of Students");
        tnumS.setFont(new Font("Arial", Font.BOLD, 20));
        tnumS.setSize(350, 20);
        tnumS.setLocation(420, 100);
        tnumS.setForeground(Color.WHITE);
        background.add(tnumS);


        JLabel mail = new JLabel("Organisations Email");//have to include the email validation
        mail.setFont(new Font("Arial", Font.BOLD, 20));
        mail.setSize(350, 20);
        mail.setLocation(5, 150);
        mail.setForeground(Color.WHITE);
        background.add(mail);

        tmail = new JTextField();
        tmail.setFont(new Font("Arial", Font.BOLD, 15));
        tmail.setSize(150, 20);
        tmail.setLocation(200, 150);
        background.add(tmail);

        username = new JLabel("Set Username");
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setSize(300, 20);
        username.setLocation(467, 150);
        username.setForeground(Color.WHITE);
        background.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.BOLD, 15));
        tusername.setSize(150, 20);
        tusername.setLocation(600, 150);
        background.add(tusername);


        JLabel area = new JLabel("School's Area");
        area.setFont(new Font("Arial", Font.BOLD, 20));
        area.setSize(200, 20);
        area.setLocation(64, 200);
        area.setForeground(Color.WHITE);
        background.add(area);

        tarea = new JTextField();
        tarea.setFont(new Font("Arial", Font.BOLD, 15));
        tarea.setSize(150, 20);
        tarea.setLocation(200, 200);
        background.add(tarea);

        JLabel password = new JLabel("Set Password");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setSize(300, 20);
        password.setLocation(467, 200);
        password.setForeground(Color.WHITE);
        background.add(password);

        tpassword = new JPasswordField();
        tpassword.setFont(new Font("Arial", Font.BOLD, 15));
        tpassword.setSize(150, 20);
        tpassword.setLocation(600, 200);
        background.add(tpassword);

        numT = new JSpinner(numberT);
        numT.setFont(new Font("Arial", Font.BOLD, 20));
        numT.setSize(30, 20);
        numT.setLocation(225, 250);
        background.add(numT);

        JLabel tnumT = new JLabel("Number of Professors");
        tnumT.setFont(new Font("Arial", Font.BOLD, 20));
        tnumT.setSize(300, 20);
        tnumT.setLocation(14, 250);
        tnumT.setForeground(Color.WHITE);
        background.add(tnumT);

        JLabel rpassword = new JLabel("Repeat Password");
        rpassword.setFont(new Font("Arial", Font.BOLD, 20));
        rpassword.setSize(300, 20);
        rpassword.setLocation(430, 250);
        rpassword.setForeground(Color.WHITE);
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

        term.setForeground(Color.WHITE);

        submit.setForeground(Color.WHITE);
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        reset.setSize(100, 20);
        reset.setLocation(420, 350);
        reset.addActionListener(this);
        background.add(reset);
        reset.setForeground(Color.WHITE);
        reset.setOpaque(false);
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

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            boolean ok = false;
            String orgName = tname.getText();
            String orgMail = tmail.getText();
            String orgArea = tarea.getText();
            int numTe = (int) numT.getValue();
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
            }else if(!GuiClass.isValidEmail(orgMail)){
                tmail.setText("");
            } else {
                usernames.add(username);
                passwords.add(password);
                Universities u = new Universities(orgName,orgArea,(numTe+numSt),orgMail);
                GuiClass.registrationAutomatedMail(orgMail);
                ok = true;
            }
            if(ok) {
                dispose();
                GuiClass.alreadyUserOption("School menu log form");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tarea.setText(def);
            tmail.setText(def);
            tpassword.setText(def);
            trpassword.setText(def);
            username.setText(def);
            numT.setValue(1);
            numS.setValue(1);

            term.setSelected(false);

        }

    }
}
