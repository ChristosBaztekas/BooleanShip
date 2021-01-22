package covid.app.gui.bool.ship.menus;

import covid.app.data.dao.UserDaoImpl;
import covid.app.gui.bool.ship.login.LogNursingHome;
import covid.app.gui.bool.ship.login.LogSchool;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolMenu extends JFrame implements ActionListener {

    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");
    private final JMenuItem i1 = new JMenuItem("Modify students");
    private final JMenuItem i2 = new JMenuItem("Modify teachers");
    private final JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private final JMenuItem i4 = new JMenuItem("Status of your School");
    private final JMenuItem i5 = new JMenuItem("Send email to all registered people of your organisation");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");
    public SchoolMenu(){
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        JMenuBar controlsMenu = new JMenuBar();
        setJMenuBar(controlsMenu);
        controlsMenu.setBackground(Color.ORANGE);
        JMenu mainMenus = new JMenu("School user Menu");
        controlsMenu.add(mainMenus);
        JMenu help = new JMenu("Help");
        controlsMenu.add(help);
        JMenu contactUs = new JMenu("Contact us");
        controlsMenu.add(contactUs);
        JMenu rateUs = new JMenu("Rate us");
        controlsMenu.add(rateUs);
        JMenu exitm = new JMenu("Close Program");
        controlsMenu.add(exitm);
        exitm.add(close);
        mainMenus.add(i1);
        mainMenus.add(i2);
        mainMenus.add(i3);
        mainMenus.add(i4);

        mainMenus.add(i5);

        mainMenus.add(exit);
        JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
        help.add(frequentlyAskedQuestions);
        help.add(Problems);
        rateUs.add(helpUsBecomeBetter);
        contactUs.add(emailAd);


        Problems.addActionListener(this);
        JMenuItem phone = new JMenuItem("Phone number for emergency");
        phone.addActionListener(this);
        emailAd.addActionListener(this);
        helpUsBecomeBetter.addActionListener(this);
        close.addActionListener(this);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);

        i5.addActionListener(this);
        exit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
            GuiClass.createHumans("Student","School","Student", LogSchool.getOrgname());
        } else if (e.getSource() == i2) {
            GuiClass.createHumans("Teacher","School","Teacher", LogSchool.getOrgname());
        } else if (e.getSource() == i3) {
            String ans_afm = JOptionPane.showInputDialog("Please write the afm of the covid case");

            if (GuiClass.isValidAfm(ans_afm)) {
                DBConnectionManager manager = new DBConnectionManager();
                UserDaoImpl impl2 = new UserDaoImpl(manager);
                if(impl2.findHumanFromAfm(ans_afm)){
                    DBConnectionManager manager2 = new DBConnectionManager();
                    UserDaoImpl impl = new UserDaoImpl(manager2);
                    impl.findHumanFromAfmAndOrgToDeclareCase(ans_afm, LogSchool.getOrgname());
                    GuiClass.createContact(ans_afm);
                }
            }
        } else if (e.getSource() == i4) {

        } else if (e.getSource() == i5) {

        }  else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        }else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/KBCC3T3?fbclid=IwAR040v9NCl8E_HtLfM2zO7ah2o-ufh8-ZAKnyfCE0GBPyQ-u03cFZp6nk5A");
        }else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        }else if(e.getSource() == Problems){
            GuiClass.sendingProblem();
        }
    }
}
