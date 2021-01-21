package covid.app.gui.bool.ship.menus;

import covid.app.gui.bool.ship.mainMenu.GuiClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolMenu extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar controlsMenu = new JMenuBar();

    private JMenu mainMenus = new JMenu("School user Menu");
    private JMenu help = new JMenu("Help");
    private JMenu contactUs = new JMenu("Contact us");
    private JMenu rateUs = new JMenu("Rate us");
    private JMenu exitm = new JMenu("Close Program");

    private JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");

    private JMenuItem phone = new JMenuItem("Phone number for emergency");
    private JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private JMenuItem emailAd = new JMenuItem("Email address");

    private JMenuItem i1 = new JMenuItem("Modify students and classes");
    private JMenuItem i2 = new JMenuItem("Modify teachers");
    private JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private JMenuItem i4 = new JMenuItem("Status of your School");
    private JMenuItem i5 = new JMenuItem("Modify other employees");

    private JMenuItem i6 = new JMenuItem("Send email to all registered people of your organisation");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem close = new JMenuItem("Exit");
    public SchoolMenu(){
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        setJMenuBar(controlsMenu);
        controlsMenu.setBackground(Color.ORANGE);
        controlsMenu.add(mainMenus);
        controlsMenu.add(help);
        controlsMenu.add(contactUs);
        controlsMenu.add(rateUs);
        controlsMenu.add(exitm);
        exitm.add(close);
        mainMenus.add(i1);
        mainMenus.add(i2);
        mainMenus.add(i3);
        mainMenus.add(i4);
        mainMenus.add(i5);
        mainMenus.add(i6);

        mainMenus.add(exit);
        help.add(frequentlyAskedQuestions);
        help.add(Problems);
        rateUs.add(helpUsBecomeBetter);
        contactUs.add(emailAd);


        Problems.addActionListener(this);
        phone.addActionListener(this);
        emailAd.addActionListener(this);
        helpUsBecomeBetter.addActionListener(this);
        close.addActionListener(this);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        exit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
            JOptionPane.showMessageDialog(this, "Read the code it is easy!!");
        } else if (e.getSource() == i2) {

        } else if (e.getSource() == i3) {

        } else if (e.getSource() == i4) {

        } else if (e.getSource() == i5) {

        } else if (e.getSource() == i6) {

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
