package covid.app.gui.bool.ship;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgMenu extends JFrame implements ActionListener {

    private final JMenuItem phone = new JMenuItem("Phone number for emergency");
    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem i1 = new JMenuItem("All registered organizations");
    private final JMenuItem i2 = new JMenuItem("Latest statistics on the pandemic");
    private final JMenuItem i3 = new JMenuItem("All recorded case");
    private final JMenuItem i4 = new JMenuItem("All Contacts recorder");
    private final JMenuItem i5 = new JMenuItem("All test Results");
    private final JMenuItem i6 = new JMenuItem("Cases by regions");
    private final JMenuItem i7 = new JMenuItem("Send email to all registered Organisations");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");

    public OrgMenu() {
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        JMenuBar controlGovMenu = new JMenuBar();
        setJMenuBar(controlGovMenu);
        controlGovMenu.setBackground(Color.ORANGE);
        JMenu mainMenug = new JMenu("User Surveillance Menu.");
        controlGovMenu.add(mainMenug);
        JMenu help = new JMenu("Help");
        controlGovMenu.add(help);
        JMenu contactUs = new JMenu("Contact us");
        controlGovMenu.add(contactUs);
        JMenu rateUs = new JMenu("Rate us");
        controlGovMenu.add(rateUs);
        JMenu exitm = new JMenu("Close Program");
        controlGovMenu.add(exitm);
        exitm.add(close);
        mainMenug.add(i1);
        mainMenug.add(i2);
        mainMenug.add(i3);
        mainMenug.add(i4);
        mainMenug.add(i5);
        mainMenug.add(i6);
        mainMenug.add(i7);



        mainMenug.add(exit);
        JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
        help.add(frequentlyAskedQuestions);
        help.add(Problems);
        rateUs.add(helpUsBecomeBetter);
        contactUs.add(emailAd);
        JMenu emergencyContact = new JMenu("Emergency contact");
        contactUs.add(emergencyContact);
        emergencyContact.add(phone);

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
        i7.addActionListener(this);
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

        }else if (e.getSource() == i7) {
            String emailAddress = JOptionPane.showInputDialog("Input the recipient's email address");
            String subject = JOptionPane.showInputDialog("Input subject");
            String mainText = JOptionPane.showInputDialog("Input main text");
            try {
                JavaMailUtil.sendMail(emailAddress,subject,mainText);
            } catch (MessagingException messagingException) {
                JOptionPane.showMessageDialog(this,"An error occurred please ensure that your email address is right!");
            }

        }  else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        }else if (e.getSource() == phone) {
            JOptionPane.showMessageDialog(null, "Only in case of emergency feel free to contact us any time in 6983461347!");
        }else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c");
        }else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        }else if(e.getSource() == Problems){
            GuiClass.sendingProblem();
        }

    }
}

