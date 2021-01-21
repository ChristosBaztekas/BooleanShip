package covid.app.gui.bool.ship.menus;


import covid.app.gui.bool.ship.login.LogUniversity;
import covid.app.gui.bool.ship.mainMenu.GuiClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversityMenu extends JFrame implements ActionListener {

    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem i1 = new JMenuItem("Modify Students");
    private final JMenuItem i2 = new JMenuItem("Modify Professors");
    private final JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private final JMenuItem i4 = new JMenuItem("Status of your University");

    private final JMenuItem i5 = new JMenuItem("Send email to all registered people of your organisation");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");
    public UniversityMenu(){
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        JMenuBar controluMenu = new JMenuBar();
        setJMenuBar(controluMenu);
        controluMenu.setBackground(Color.ORANGE);
        JMenu mainMenuu = new JMenu("University user Menu");
        controluMenu.add(mainMenuu);
        JMenu help = new JMenu("Help");
        controluMenu.add(help);
        JMenu contactUs = new JMenu("Contact us");
        controluMenu.add(contactUs);
        JMenu rateUs = new JMenu("Rate us");
        controluMenu.add(rateUs);
        JMenu exitm = new JMenu("Close Program");
        controluMenu.add(exitm);
        exitm.add(close);
        mainMenuu.add(i1);
        mainMenuu.add(i2);
        mainMenuu.add(i3);
        mainMenuu.add(i4);

        mainMenuu.add(i5);

        mainMenuu.add(exit);
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
           GuiClass.createHumans("Student","University","Student", LogUniversity.getOrgname());
        } else if (e.getSource() == i2) {
            GuiClass.createHumans("Professor","University","Professor", LogUniversity.getOrgname());
        } else if (e.getSource() == i3) {

        } else if (e.getSource() == i4) {

        }  else if (e.getSource() == i5) {

        }  else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        }else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/KB3FYGX?fbclid=IwAR0JCQaOG14esMC41xuWjlMF0sckpC6TaPpSYRQnLmpJbAtNgIxDtBXM6I8");
        }else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        }else if(e.getSource() == Problems){
            GuiClass.sendingProblem();
        }
    }
}

