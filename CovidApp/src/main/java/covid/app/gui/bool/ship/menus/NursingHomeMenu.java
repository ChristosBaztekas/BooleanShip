package covid.app.gui.bool.ship.menus;


import covid.app.data.dao.DaoImpl;
import covid.app.gui.bool.ship.login.LogNursingHome;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NursingHomeMenu extends JFrame implements ActionListener {
    private final JTextArea allOrgs = new JTextArea(20, 40);
    private final JMenuItem terms = new JMenuItem("Terms and Conditions");
    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem i1 = new JMenuItem("Modify employees");
    private final JMenuItem i2 = new JMenuItem("Modify the list of elder Residents");
    private final JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private final JMenuItem i4 = new JMenuItem("Input additional contacts");
    private final JMenuItem i5 = new JMenuItem("Status of your Nursing Home");
    private final JMenuItem i6 = new JMenuItem("Send email to all registered people of your organisation");
    private final JMenuItem i7 = new JMenuItem("Change password");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");
    private final JMenuItem freq1 = new JMenuItem("What does the option modify employees?");
    private final JMenuItem freq2 = new JMenuItem("What does the option modify elder residents?");
    private final JMenuItem freq3 = new JMenuItem("What does the option declare a case of covid?");
    private final JMenuItem freq4 = new JMenuItem("What does the option input additional contacts?");
    private final JMenuItem freq5 = new JMenuItem("What does the option status of your nursing home?");
    private final JMenuItem freq6 = new JMenuItem("What does the option send email to all registered people?");
    private final JMenuItem freq7 = new JMenuItem("How to Change password?");
    private final JMenuItem freq8 = new JMenuItem("How to contact us?");
    private final JMenuItem freq9 = new JMenuItem("How to rate as?");
    private final JMenuItem freq10 = new JMenuItem("Is your data safe?");
    private final JMenuItem freq11 = new JMenuItem("Is your data used by other companies?");
    private final JMenuItem freq12 = new JMenuItem("More info");

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
        mainMenun.add(i5);
        mainMenun.add(i6);
        mainMenun.add(i7);

        mainMenun.add(exit);
        JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
        help.add(frequentlyAskedQuestions);
        help.add(Problems);
        rateUs.add(helpUsBecomeBetter);
        contactUs.add(emailAd);
        frequentlyAskedQuestions.add(freq1);
        frequentlyAskedQuestions.add(freq2);
        frequentlyAskedQuestions.add(freq3);
        frequentlyAskedQuestions.add(freq4);
        frequentlyAskedQuestions.add(freq5);
        frequentlyAskedQuestions.add(freq6);
        frequentlyAskedQuestions.add(freq7);
        frequentlyAskedQuestions.add(freq8);
        frequentlyAskedQuestions.add(freq9);
        frequentlyAskedQuestions.add(freq10);
        frequentlyAskedQuestions.add(freq11);
        frequentlyAskedQuestions.add(freq12);
        freq1.addActionListener(this);
        freq2.addActionListener(this);
        freq3.addActionListener(this);
        freq4.addActionListener(this);
        freq5.addActionListener(this);
        freq6.addActionListener(this);
        freq7.addActionListener(this);
        freq8.addActionListener(this);
        freq9.addActionListener(this);
        freq10.addActionListener(this);
        freq11.addActionListener(this);
        freq12.addActionListener(this);

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
        i6.addActionListener(this);
        i7.addActionListener(this);
        exit.addActionListener(this);
        help.add(terms);
        terms.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
            GuiClass.createHumans("Employee","Nursing Home","Employee", LogNursingHome.getOrgname());
        } else if (e.getSource() == i2) {
            GuiClass.createHumans("Elder Resident","Nursing Home","Elder Resident",LogNursingHome.getOrgname());
        } else if (e.getSource() == i3) {
            String ans_afm = JOptionPane.showInputDialog("Please write the afm of the covid case");

            if (GuiClass.isValidAfm(ans_afm)) {
                DBConnectionManager manager = new DBConnectionManager();
                DaoImpl impl2 = new DaoImpl(manager);
                if(impl2.findHumanFromAfm(ans_afm)){
                    DBConnectionManager manager2 = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager2);
            impl.findHumanFromAfmAndOrgToDeclareCase(ans_afm,LogNursingHome.getOrgname());
            GuiClass.createContact(ans_afm);
                }else{
                    JOptionPane.showMessageDialog(null, "This Person is not registered.","Person not found",JOptionPane.ERROR_MESSAGE);
                }
            }


        } else if (e.getSource() == i4) {
       GuiClass.inputAdditionalContacts();
        }else if (e.getSource() == i5) {
       GuiClass.orgStatus(LogNursingHome.getOrgname());
        } else if (e.getSource() == i6) {
            String subject = JOptionPane.showInputDialog("Please write the Subject");
            String mainText = JOptionPane.showInputDialog("Please write the main Text");
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.sendMailToAllMembersofYourOrg(subject,mainText,LogNursingHome.getOrgname());
        } else if (e.getSource() == i7) {
            GuiClass verification = new GuiClass();
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            if(verification.validation(impl.findOrgEmailfromOrgName(LogNursingHome.getOrgname()))) {
                String newPas = JOptionPane.showInputDialog("Please write as the new password");
                impl.changePassword(newPas, LogNursingHome.getOrgUsername());
            }else{
                JOptionPane.showMessageDialog(null, "Try again.If you lost access to your mail contact as.","Error",JOptionPane.ERROR_MESSAGE);
            }
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
        }else if (e.getSource() == terms) {
            GuiClass.managingWebsitesByUrl("https://github.com/ChristosBaztekas/BooleanShip/blob/main/Terms%20and%20Conditions.docx");

        }else if (e.getSource() == freq1) {
            JOptionPane.showMessageDialog(null, "This option helps you add your employees.", "Answer", JOptionPane.PLAIN_MESSAGE);
        }else if (e.getSource() == freq2) {
            JOptionPane.showMessageDialog(null, "This option helps you add your elder residents.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq3) {
            JOptionPane.showMessageDialog(null, "This option allows you to declare a case of covid using his afm.\nAfter declaring the case the member is informed to stay home.\nThen we ask you for his contacts if they are available.\nThe contacts are also informed immediately.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq4) {
            JOptionPane.showMessageDialog(null, "This option allows you to declare more contacts of a case you declared.\nFirst the afm of the person with covid is asked.\nIf the afm exists we inform his contacts immediately.", "Answer", JOptionPane.PLAIN_MESSAGE);
        }else if (e.getSource() == freq5) {
            JOptionPane.showMessageDialog(null, "This option informs you about the number of cases and the number of members you have.\nIf the cases are more than 10% of your members the system suggest you the quarantine mode.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq6) {
            JOptionPane.showMessageDialog(null, "Using the current option you can write subject and main text.\nThen an email containing this information is sent to all your registered members.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq7) {
            JOptionPane.showMessageDialog(null, "First to change password you choose tha menu option.\nThen you need to verify that is you by writing the 6 digits code\nthat we emailed you.Finally you write the new password and password changes.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq8) {
            JOptionPane.showMessageDialog(null, "You can contact as using the menu option.\nFirst you will receive an automatic message by us.\nWe answer all your messages within 24 hours.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq10) {
            JOptionPane.showMessageDialog(null, "Yes our database is very safe.\nTo enter the government menu you have to verify so \na hacker is not able to have access using only the government's password.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq9) {
            JOptionPane.showMessageDialog(null, "To rate as you have to choose the rate us option.\nThen you will be redirected to a survey monkey.", "Answer", JOptionPane.PLAIN_MESSAGE);
        }else if (e.getSource() == freq11) {
            JOptionPane.showMessageDialog(null, "No,other companies do not have access to our database.\nThis app is created to help your organization survive the pandemic.", "Answer", JOptionPane.PLAIN_MESSAGE);

        }else if (e.getSource() == freq12) {
            allOrgs.append("If you still have questions please read the manual or  contact us at our email: booleanship@gmail.com .");
            allOrgs.setFont(new Font("Arial", Font.BOLD, 14));
            allOrgs.setEditable(false);
            allOrgs.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(null, allOrgs, "Answer", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Opening the manual", "Manual", JOptionPane.PLAIN_MESSAGE);
            GuiClass.managingWebsitesByUrl("https://github.com/ChristosBaztekas/BooleanShip");
        }
    }
}
