package covid.app.gui.bool.ship.menus;

import covid.app.data.dao.DaoImpl;
import covid.app.gui.bool.ship.login.LogLabor;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaborMenu extends JFrame implements ActionListener {

    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");


    private final JMenuItem i1 = new JMenuItem("Modify employees");
    private final JMenuItem i2 = new JMenuItem("Declare a Case of Covid-19");
    private final JMenuItem i3 = new JMenuItem("Input additional contacts");
    private final JMenuItem i4 = new JMenuItem("Status of your Labor");
    private final JMenuItem i6 = new JMenuItem("Change password");


    private final JMenuItem i5 = new JMenuItem("Send email to all registered people of your organisation");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final JMenuItem close = new JMenuItem("Exit");
    public LaborMenu(){
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid.jpg")));
        setLayout(new FlowLayout());
        JMenuBar controlsMenu = new JMenuBar();
        setJMenuBar(controlsMenu);
        controlsMenu.setBackground(Color.ORANGE);
        JMenu mainMenul = new JMenu("Labor user Menu");
        controlsMenu.add(mainMenul);
        JMenu help = new JMenu("Help");
        controlsMenu.add(help);
        JMenu contactUs = new JMenu("Contact us");
        controlsMenu.add(contactUs);
        JMenu rateUs = new JMenu("Rate us");
        controlsMenu.add(rateUs);
        JMenu exitm = new JMenu("Close Program");
        controlsMenu.add(exitm);
        exitm.add(close);

        mainMenul.add(i1);
        mainMenul.add(i2);
        mainMenul.add(i3);
        mainMenul.add(i4);
        mainMenul.add(i5);
        mainMenul.add(i6);

        mainMenul.add(exit);
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
        exit.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == i1) {
           GuiClass.createHumans("Employee","Labor","Employee", LogLabor.getOrgname());
        } else if (e.getSource() == i2) {
           String ans_afm = JOptionPane.showInputDialog("Please write the afm of the covid case");

           if (GuiClass.isValidAfm(ans_afm)) {
               DBConnectionManager manager = new DBConnectionManager();
               DaoImpl impl2 = new DaoImpl(manager);
               if(impl2.findHumanFromAfm(ans_afm)){
                   DBConnectionManager manager2 = new DBConnectionManager();
                   DaoImpl impl = new DaoImpl(manager2);
                   impl.findHumanFromAfmAndOrgToDeclareCase(ans_afm, LogLabor.getOrgname());
                   GuiClass.createContact(ans_afm);
               }else{
                   JOptionPane.showMessageDialog(null, "This Person is not registered.","Person not found",JOptionPane.ERROR_MESSAGE);
               }
           }
        } else if (e.getSource() == i3) {
           GuiClass.inputAdditionalContacts();

        }else if (e.getSource() == i4) {
           GuiClass.orgStatus(LogLabor.getOrgname());
       }  else if (e.getSource() == i5) {
           String subject = JOptionPane.showInputDialog("Please write the Subject");
           String mainText = JOptionPane.showInputDialog("Please write the main Text");
           DBConnectionManager manager = new DBConnectionManager();
           DaoImpl impl = new DaoImpl(manager);
           impl.sendMailToAllMembersofYourOrg(subject,mainText, LogLabor.getOrgname());
        }else if (e.getSource() == i6) {
           GuiClass verification = new GuiClass();
           DBConnectionManager manager = new DBConnectionManager();
           DaoImpl impl = new DaoImpl(manager);
           if(verification.validation(impl.findOrgEmailfromOrgName(LogLabor.getOrgname()))) {
               String newPas = JOptionPane.showInputDialog("Please write as the new password");
               impl.changePassword(newPas, LogLabor.getOrgUsername());
           }else{
               JOptionPane.showMessageDialog(null, "Try again.If you lost access to your mail contact as.","Error",JOptionPane.ERROR_MESSAGE);
           }
       }  else if (e.getSource() == exit) {
            GuiClass.exitMethod();
        } else if (e.getSource() == close) {
            GuiClass.exitMethod();
        }else if (e.getSource() == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/KN73HPZ?fbclid=IwAR2uWvOaf0kikNlN0oJ0vzydLIKR4AOQ26DUtK0vrb8lvfTjfQdAhc20RUw");
        }else if (e.getSource() == emailAd) {
            GuiClass.contactUs();
        }else if(e.getSource() == Problems){
          GuiClass.sendingProblem();
        }
    }
}

