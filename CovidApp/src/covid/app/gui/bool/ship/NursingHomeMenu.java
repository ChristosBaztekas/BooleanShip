package covid.app.gui.bool.ship;



import covid.app.main.app.boolship.Human;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NursingHomeMenu extends JFrame implements ActionListener {

    private static final ArrayList<Human> allNemployees = new ArrayList<>();

    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem i1 = new JMenuItem("Modify employees");
    private final JMenuItem i2 = new JMenuItem("Modify the list of guests");
    private final JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private final JMenuItem i4 = new JMenuItem("Status of your NursingHome");
    //private JMenuItem i5 = new JMenuItem("Modify other connected with your org people");
    // backend does not support i5 option
    private final JMenuItem i6 = new JMenuItem("Send email to all registered people of your organisation");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");

    public NursingHomeMenu() {
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        JMenuBar controlnMenu = new JMenuBar();
        setJMenuBar(controlnMenu);
        controlnMenu.setBackground(Color.ORANGE);
        JMenu mainMenun = new JMenu("Nursing Home user Menu");
        controlnMenu.add(mainMenun);
        JMenu help = new JMenu("Help");
        controlnMenu.add(help);
        JMenu contactUs = new JMenu("Contact us");
        controlnMenu.add(contactUs);
        JMenu rateUs = new JMenu("Rate us");
        controlnMenu.add(rateUs);
        JMenu exitm = new JMenu("Close Program");
        controlnMenu.add(exitm);
        exitm.add(close);
        mainMenun.add(i1);
        mainMenun.add(i2);
        mainMenun.add(i3);
        mainMenun.add(i4);
        //mainMenun.add(i5);
        mainMenun.add(i6);

        mainMenun.add(exit);
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
        //i5.addActionListener(this);
        i6.addActionListener(this);
        exit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
            GuiClass.createHumans("Employee",allNemployees);
        } else if (e.getSource() == i2) {

        } else if (e.getSource() == i3) {

        } else if (e.getSource() == i4) {

        } else if (e.getSource() == i6) {

        } else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        } else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/KGZK9CH?fbclid=IwAR1io-u8Mv6OyjvYKSf4TisnOr-LxRofNlXnnQSTWW_UrAudrQ7Z5QlsudU");
        } else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        } else if (e.getSource() == Problems) {
            GuiClass.sendingProblem();
        }
    }
}
