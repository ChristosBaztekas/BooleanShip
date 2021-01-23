package covid.app.gui.bool.ship.menus;

import covid.app.data.dao.DaoImpl;
import covid.app.gui.bool.ship.mainMenu.GuiClass;
import covid.app.manager.DBConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrgMenu extends JFrame implements ActionListener {

    private final JMenuItem phone = new JMenuItem("Phone number for emergency");
    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem i1 = new JMenuItem("All registered organizations");
    private final JMenuItem i2 = new JMenuItem("All recorded cases");
    private final JMenuItem i3 = new JMenuItem("All Contacts recorded");
    private final JMenuItem i4 = new JMenuItem("Send email to all registered Organisations");
    private final JMenuItem i5 = new JMenuItem("Statistics of registered organisations");
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
        mainMenug.add(i2);
        mainMenug.add(i3);
        mainMenug.add(i4);
        mainMenug.add(i5);



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
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        exit.addActionListener(this);
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
        }  else if (e.getSource() == i3) {
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.getAllcontacts();
        } else if (e.getSource() == i4) {

            String subject = JOptionPane.showInputDialog("Input subject");
            String mainText = JOptionPane.showInputDialog("Input main text");
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl = new DaoImpl(manager);
            impl.sendMailToAllorganisations(subject, mainText);

        }else if (e.getSource() == i5) {
            //create piechart
            // piechart pie = new piechart();
            //pie.launch(covid.app.gui.bool.ship.mainMenu.Main.a);
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
        }

    }
}

