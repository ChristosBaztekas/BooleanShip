package covid.app.gui.bool.ship;

import CovidApp.Gui.BooleanShip.GuiClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NursingHomeMenu extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar controlnMenu = new JMenuBar();

    private JMenu mainMenun = new JMenu("Nursing Home user Menu");
    private JMenu help = new JMenu("Help");
    private JMenu contactUs = new JMenu("Contact us");
    private JMenu rateUs = new JMenu("Rate us");
    private JMenu exitm = new JMenu("Close Program");

    private JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");

    private JMenuItem phone = new JMenuItem("Phone number for emergency");
    private JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private JMenuItem emailAd = new JMenuItem("Email address");

    private JMenuItem i1 = new JMenuItem("Modify employees");
    private JMenuItem i2 = new JMenuItem("Modify the list of guests");
    private JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private JMenuItem i4 = new JMenuItem("Status of your NursingHome");
    //private JMenuItem i5 = new JMenuItem("Modify other connected with your org people");
    // backend does not support i5 option
    private JMenuItem i6 = new JMenuItem("Send email to all registered people of your organisation");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem close = new JMenuItem("Exit");

    public NursingHomeMenu() {
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        setJMenuBar(controlnMenu);
        controlnMenu.setBackground(Color.ORANGE);
        controlnMenu.add(mainMenun);
        controlnMenu.add(help);
        controlnMenu.add(contactUs);
        controlnMenu.add(rateUs);
        controlnMenu.add(exitm);
        exitm.add(close);
        mainMenun.add(i1);
        mainMenun.add(i2);
        mainMenun.add(i3);
        mainMenun.add(i4);
        //mainMenun.add(i5);
        mainMenun.add(i6);

        mainMenun.add(exit);
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
        //i5.addActionListener(this);
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

        } else if (e.getSource() == i6) {

        } else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        } else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c");
        } else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        } else if (e.getSource() == Problems) {
            GuiClass.sendingProblem();
        }
    }
}
