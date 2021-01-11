package covid.app.gui.bool.ship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversityMenu extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar controluMenu = new JMenuBar();

    private JMenu mainMenuu = new JMenu("Labor user Menu.");
    private JMenu help = new JMenu("Help");
    private JMenu contactUs = new JMenu("Contact us");
    private JMenu rateUs = new JMenu("Rate us");
    private JMenu exitm = new JMenu("Close Program");

    private JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");

    private JMenuItem phone = new JMenuItem("Phone number for emergency");
    private JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private JMenuItem emailAd = new JMenuItem("Email address");

    private JMenuItem i1 = new JMenuItem("Modify departments");
    private JMenuItem i2 = new JMenuItem("Modify professors");
    private JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private JMenuItem i4 = new JMenuItem("Status of your University");
    private JMenuItem i5 = new JMenuItem("Modify other related with your organisation people");

    private JMenuItem i6 = new JMenuItem("Send email to all registered people of your organisation");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem close = new JMenuItem("Exit");
    public UniversityMenu(){
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        setJMenuBar(controluMenu);
        controluMenu.setBackground(Color.ORANGE);
        controluMenu.add(mainMenuu);
        controluMenu.add(help);
        controluMenu.add(contactUs);
        controluMenu.add(rateUs);
        controluMenu.add(exitm);
        exitm.add(close);
        mainMenuu.add(i1);
        mainMenuu.add(i2);
        mainMenuu.add(i3);
        mainMenuu.add(i4);
        mainMenuu.add(i5);
        mainMenuu.add(i6);

        mainMenuu.add(exit);
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
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/KB3FYGX?fbclid=IwAR0JCQaOG14esMC41xuWjlMF0sckpC6TaPpSYRQnLmpJbAtNgIxDtBXM6I8");
        }else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        }else if(e.getSource() == Problems){
            GuiClass.sendingProblem();
        }
    }
}

