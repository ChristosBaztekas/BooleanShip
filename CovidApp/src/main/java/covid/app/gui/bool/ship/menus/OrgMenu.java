package covid.app.gui.bool.ship.menus;

import covid.app.data.dao.DaoImpl;
import covid.app.gui.bool.ship.login.LogOrg;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.gui.bool.ship.mainMenu.JavaMailUtil;
import covid.app.manager.DBConnectionManager;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgMenu extends JFrame implements ActionListener {
    private final JMenuItem phone = new JMenuItem("Phone number for emergency");
    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");
    private final JMenuItem terms = new JMenuItem("Terms and Conditions");
    private final JMenuItem i1 = new JMenuItem("All registered organizations");
    private final JMenuItem i2 = new JMenuItem("All recorded cases");
    private final JMenuItem i3 = new JMenuItem("All Contacts recorded");
    private final JMenuItem i4 = new JMenuItem("Send email to all registered Organisations");
    private final JMenuItem i5 = new JMenuItem("Declare a tested positive person");
    private final JMenuItem i6 = new JMenuItem("Change password");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");
    private final JMenuItem freq1 = new JMenuItem("What does option all registered organizations?");
    private final JMenuItem freq2 = new JMenuItem("What does option all recorded cases?");
    private final JMenuItem freq3 = new JMenuItem("What does option all Contacts recorded");
    private final JMenuItem freq4 = new JMenuItem("What does option send email to all registered Organisations");
    private final JMenuItem freq5 = new JMenuItem("What does option declare a tested positive person?");

    private final JMenuItem freq7 = new JMenuItem("How to Change password?");
    private final JMenuItem freq8 = new JMenuItem("How to contact us?");
    private final JMenuItem freq9 = new JMenuItem("How to rate as?");
    private final JMenuItem freq10 = new JMenuItem("Is your data safe?");
    private final JMenuItem freq11 = new JMenuItem("Is your data used by other companies?");

    public OrgMenu() {
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        JMenuBar controlGovMenu = new JMenuBar();
        setJMenuBar(controlGovMenu);
        controlGovMenu.setBackground(Color.ORANGE);
        JMenu mainMenug = new JMenu("User Surveillance Menu");
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
        mainMenug.add(i2);
        mainMenug.add(i3);
        mainMenug.add(i4);
        mainMenug.add(i5);
        mainMenug.add(i6);


        mainMenug.add(exit);
        JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
        help.add(frequentlyAskedQuestions);
        help.add(Problems);
        help.add(terms);
        terms.addActionListener(this);
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
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        exit.addActionListener(this);
        frequentlyAskedQuestions.add(freq1);
        frequentlyAskedQuestions.add(freq2);
        frequentlyAskedQuestions.add(freq3);
        frequentlyAskedQuestions.add(freq4);
        frequentlyAskedQuestions.add(freq5);

        frequentlyAskedQuestions.add(freq7);
        frequentlyAskedQuestions.add(freq8);
        frequentlyAskedQuestions.add(freq9);
        frequentlyAskedQuestions.add(freq10);
        frequentlyAskedQuestions.add(freq11);
        JMenuItem freq12 = new JMenuItem("More info");
        frequentlyAskedQuestions.add(freq12);
        freq1.addActionListener(this);
        freq2.addActionListener(this);
        freq3.addActionListener(this);
        freq4.addActionListener(this);
        freq5.addActionListener(this);

        freq7.addActionListener(this);
        freq8.addActionListener(this);
        freq9.addActionListener(this);
        freq10.addActionListener(this);
        freq11.addActionListener(this);
        freq12.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.getAllOrgs();
        } else if (e.getSource() == i2) {
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.getAllcases();
        } else if (e.getSource() == i3) {
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.getAllcontacts();
        } else if (e.getSource() == i4) {

            String subject = JOptionPane.showInputDialog("Input subject");
            String mainText = JOptionPane.showInputDialog("Input main text");
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.sendMailToAllorganisations(subject, mainText);

        } else if (e.getSource() == i5) {
            String ans_afm = JOptionPane.showInputDialog("Please write the afm of the person tested positive");

            if (GuiClass.isValidAfm(ans_afm)) {
                DBConnectionManager manager = new DBConnectionManager();
                DaoImpl impl2 = new DaoImpl(manager);
                if (impl2.findHumanFromAfm(ans_afm)) {
                    DBConnectionManager manager2 = new DBConnectionManager();
                    DaoImpl impl = new DaoImpl(manager2);
                    impl.declareCase(ans_afm, "Positive");

                    try {
                        JavaMailUtil.sendMail(impl.findHumanEmailFromAfm(ans_afm), "Covid case", "Hello you were declared as a covid case please stay home.");
                        JavaMailUtil.sendMail(impl.findOrgEmailfromOrgName(impl.findHumanOrgNameFromAfm(ans_afm)), "Member found positive", "We inform you that the member of your organisation with afm:" + ans_afm + " was found positive.Please inform as via the suitable form of the application about his contacts and implement the actions demanded by the protocols.");

                    } catch (MessagingException messagingException) {
                        JOptionPane.showMessageDialog(null, "Something unexpected happened.Please check your internet connection.", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                    GuiClass.createContact(ans_afm);
                } else {
                    JOptionPane.showMessageDialog(null, "This Person is not registered.", "Person not found", JOptionPane.ERROR_MESSAGE);
                }
            }


        } else if (e.getSource() == i6) {
            GuiClass verification = new GuiClass();
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            if (verification.validation(impl.findOrgEmailfromOrgName(LogOrg.getOrgname()))) {
                String newPas = JOptionPane.showInputDialog("Please write as the new password");
                impl.changePassword(newPas, LogOrg.getOrgUsername());
            }
        } else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        } else if (e.getSource() == phone) {
            JOptionPane.showMessageDialog(null, "Only in case of emergency feel free to contact us any time in 6983461347!");
        } else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c");
        } else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        } else if (e.getSource() == Problems) {
            GuiClass.sendingProblem();
        } else if (e.getSource() == terms) {
            GuiClass.managingWebsitesByUrl("https://github.com/ChristosBaztekas/BooleanShip/blob/main/Terms%20and%20Conditions.docx");

        } else if (e.getSource() == freq1) {
            JOptionPane.showMessageDialog(null, "It shows you all registered organisations and their types.", "Answer", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == freq2) {
            JOptionPane.showMessageDialog(null, "It shows you all recorder cases and their afm.", "Answer", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource() == freq3) {
            JOptionPane.showMessageDialog(null, "It shows you all the recorded contacts and their afm.", "Answer", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource() == freq4) {
            JOptionPane.showMessageDialog(null, "It allows you to send a massive email to all the organizations.\nThis option is for informing them for important changes.", "Answer", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == freq5) {
            JOptionPane.showMessageDialog(null, "This option helps you declare as a case a human you found positive to covid using his afm.\nIf the person exists in the database he is informed by an automatic email.\n In addition his organisation is also automatically informed.\nThis option help as find all his contacts fast. ", "Answer", JOptionPane.PLAIN_MESSAGE);

        }  else if (e.getSource() == freq7) {
            JOptionPane.showMessageDialog(null, "First to change password you choose tha menu option.\nThen you need to verify that is you by writing the 6 digits code\nthat we emailed you.Finally you write the new password and password changes.", "Answer", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource() == freq8) {
            JOptionPane.showMessageDialog(null, "You can contact as using the menu option.\nFirst you will receive an automatic message by us.\nWe answer all your messages within 24 hours.", "Answer", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource() == freq10) {
            JOptionPane.showMessageDialog(null, "Yes our database is very safe.\nTo enter the government menu you have to verify so \na hacker is not able to have access using only the government's password.", "Answer", JOptionPane.PLAIN_MESSAGE);

        } else if (e.getSource() == freq9) {
            JOptionPane.showMessageDialog(null, "To rate as you have to choose the rate us option.\nThen you will be redirected to a survey monkey.", "Answer", JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == freq11) {
            JOptionPane.showMessageDialog(null, "No,other companies do not have access to our database.\nThis app is created to help your organization survive the pandemic.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }

    }
}

