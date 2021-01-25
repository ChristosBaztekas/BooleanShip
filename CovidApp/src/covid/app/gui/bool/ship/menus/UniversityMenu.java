package covid.app.gui.bool.ship.menus;


import covid.app.data.dao.DaoImpl;
import covid.app.gui.bool.ship.login.LogUniversity;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversityMenu extends JFrame implements ActionListener {

    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem i1 = new JMenuItem("Modify Students");
    private final JMenuItem i2 = new JMenuItem("Modify Professors");
    private final JMenuItem i3 = new JMenuItem("Declare a Case of Covid-19");
    private final JMenuItem i4 = new JMenuItem("Input additional contacts");
    private final JMenuItem i5 = new JMenuItem("Status of your University");
    private final JMenuItem i6 = new JMenuItem("Send email to all registered people of your organisation");
    private final JMenuItem i7 = new JMenuItem("Change password");
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
        mainMenuu.add(i6);
        mainMenuu.add(i7);

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
        i6.addActionListener(this);
        i7.addActionListener(this);
        exit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == i1) {
           GuiClass.createHumans("Student","University","Student", LogUniversity.getOrgname());
        } else if (e.getSource() == i2) {
            GuiClass.createHumans("Professor","University","Professor", LogUniversity.getOrgname());
        } else if (e.getSource() == i3) {
            String ans_afm = JOptionPane.showInputDialog("Please write the afm of the covid case");

            if (GuiClass.isValidAfm(ans_afm)) {
                DBConnectionManager manager = new DBConnectionManager();
                DaoImpl impl2 = new DaoImpl(manager);
                if(impl2.findHumanFromAfm(ans_afm)){
                    DBConnectionManager manager2 = new DBConnectionManager();
                    DaoImpl impl = new DaoImpl(manager2);
                    impl.findHumanFromAfmAndOrgToDeclareCase(ans_afm, LogUniversity.getOrgname());
                    GuiClass.createContact(ans_afm);
                }else{
                    JOptionPane.showMessageDialog(null, "This Person is not registered.","Person not found",JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == i4) {
            GuiClass.inputAdditionalContacts();

        }  else if (e.getSource() == i5) {
            GuiClass.orgStatus(LogUniversity.getOrgname());
        }else if (e.getSource() == i6) {
            String subject = JOptionPane.showInputDialog("Please write the Subject");
            String mainText = JOptionPane.showInputDialog("Please write the main Text");
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.sendMailToAllMembersofYourOrg(subject,mainText, LogUniversity.getOrgname());
        } else if (e.getSource() == i7) {
            GuiClass verification = new GuiClass();
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            if(verification.validation(impl.findOrgEmailfromOrgName(LogUniversity.getOrgname()))) {
                String newPas = JOptionPane.showInputDialog("Please write as the new password");
                impl.changePassword(newPas, LogUniversity.getOrgUsername());
            }else{
                JOptionPane.showMessageDialog(null, "Try again.If you lost access to your mail contact as.","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == exit) {
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

