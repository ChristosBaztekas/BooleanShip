package CovidApp.Gui.BooleanShip;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class GuiClass extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar mainApp = new JMenuBar();
    private JMenu allmenus = new JMenu("All Menus Available");
    private JMenu useFullWebsitesAboutCovid = new JMenu("Usefull Websites about covid");
    private JMenu help = new JMenu("Help");
    private JMenu contactUs = new JMenu("Contact us");
    private JMenu exitMenu = new JMenu("Exit");
    private JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
    private JMenuItem eodyWebpage = new JMenuItem("Eody webpage");
    private JMenuItem whoWebpage = new JMenuItem("World Health Organisation webpage");
    private JMenuItem emailAd = new JMenuItem("Email address");

    private JMenu menu1 = new JMenu("Goverment Menu");
    private JMenu menu2 = new JMenu("Labor Menu");
    private JMenu menu3 = new JMenu("School Menu");
    private JMenu menu4 = new JMenu("University Menu");
    private JMenu menu5 = new JMenu("Nursing home Menu");
    private JMenu menu6 = new JMenu("Exit");

    private JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private JMenu rateUs = new JMenu("Rate us");

    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");


    private JMenuItem Exit = new JMenuItem("Close Program");
    private JMenuItem justExit = new JMenuItem("Exit");
    private JMenuItem gmenu = new JMenuItem("Menu and info are not available for not authorized users");

    private JMenuItem gmenu5 = new JMenuItem("Exit");

    private JMenuItem nmenu1 = new JMenuItem("Info about this menu");
    private JMenuItem nmenu2 = new JMenuItem("User menu");
    private JMenuItem nmenu3 = new JMenuItem("Sign up");
    private JMenuItem nmenu4 = new JMenuItem("Exit");

    private JMenuItem smenu1 = new JMenuItem("Info about this menu");
    private JMenuItem smenu2 = new JMenuItem("User menu");
    private JMenuItem smenu3 = new JMenuItem("Sign up");
    private JMenuItem smenu4 = new JMenuItem("Exit");

    private JMenuItem umenu1 = new JMenuItem("Info about this menu");
    private JMenuItem umenu2 = new JMenuItem("User menu");
    private JMenuItem umenu3 = new JMenuItem("Sign up");
    private JMenuItem umenu4 = new JMenuItem("Exit");

    private JMenuItem lmenu1 = new JMenuItem("Info about this menu");
    private JMenuItem lmenu2 = new JMenuItem("User menu");
    private JMenuItem lmenu3 = new JMenuItem("Sign up");
    private JMenuItem lmenu4 = new JMenuItem("Exit");


    public GuiClass() {
        setLayout(new FlowLayout());
        setJMenuBar(mainApp);
        //create image
        JLabel background;
        setSize(1200, 700);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("covid.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 700);
        mainApp.add(background);
        background.setVisible(true);
        mainApp.add(allmenus);
        mainApp.add(useFullWebsitesAboutCovid);
        mainApp.add(help);
        mainApp.add(contactUs);
        mainApp.add(justExit);
        mainApp.add(rateUs);
        mainApp.add(exitMenu);
        exitMenu.add(Exit);
        help.add(Problems);
        useFullWebsitesAboutCovid.add(whoWebpage);
        useFullWebsitesAboutCovid.add(eodyWebpage);
        contactUs.add(emailAd);
        mainApp.setSize(800, 800);
        allmenus.add(menu1);
        allmenus.add(menu2);
        allmenus.add(menu3);
        allmenus.add(menu4);
        allmenus.add(menu5);
        allmenus.add(menu6);
        rateUs.add(helpUsBecomeBetter);
        help.add(frequentlyAskedQuestions);
        menu2.add(lmenu1);
        menu2.add(lmenu2);
        menu2.add(lmenu3);

        menu2.add(lmenu4);


        menu1.add(gmenu);

        menu1.add(gmenu5);


        menu3.add(smenu1);
        menu3.add(smenu2);
        menu3.add(smenu3);

        menu3.add(smenu4);

        menu4.add(umenu1);
        menu4.add(umenu2);
        menu4.add(umenu3);

        menu4.add(umenu4);

        menu5.add(nmenu1);
        menu5.add(nmenu2);
        menu5.add(nmenu3);

        menu5.add(nmenu4);


        menu6.add(justExit);
        Exit.addActionListener(this);
        helpUsBecomeBetter.addActionListener(this);


        Problems.addActionListener(this);
        contactUs.addActionListener(this);
        eodyWebpage.addActionListener(this);
        whoWebpage.addActionListener(this);
        justExit.addActionListener(this);
        emailAd.addActionListener(this);

        gmenu.addActionListener(this);
        gmenu5.addActionListener(this);

        lmenu1.addActionListener(this);
        lmenu2.addActionListener(this);
        lmenu3.addActionListener(this);
        lmenu4.addActionListener(this);


        smenu1.addActionListener(this);
        smenu2.addActionListener(this);
        smenu3.addActionListener(this);
        smenu4.addActionListener(this);

        umenu1.addActionListener(this);
        umenu2.addActionListener(this);
        umenu3.addActionListener(this);
        umenu4.addActionListener(this);

        nmenu1.addActionListener(this);
        nmenu2.addActionListener(this);
        nmenu3.addActionListener(this);
        nmenu4.addActionListener(this);
    }

    public void setSize(int width, int height) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == justExit) {
            GuiClass.exitMethod();

        } else if (source == gmenu) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Surveillance login form");
            alreadyUserOption("Log in as a Surveillance User");
        } else if (source == gmenu5) {
            GuiClass.exitMethod();
        } else if (source == lmenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for public services and companies authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == lmenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Labor user login form");
            alreadyUserOption("Log in as a Labor User.");
        } else if (source == lmenu3) {
        } else if (source == lmenu4) {
            GuiClass.exitMethod();
        } else if (source == smenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for School authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == smenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the School login form");
            alreadyUserOption("Log in as a School User.");
        } else if (source == smenu3) {
        } else if (source == smenu4) {
            GuiClass.exitMethod();
        } else if (source == umenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for university authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == umenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the University login form");
            alreadyUserOption("Log in as a University User.");
        } else if (source == umenu3) {

        } else if (source == umenu4) {
            GuiClass.exitMethod();
        } else if (source == nmenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for Nursing home authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == nmenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Nursing Home login form");
            alreadyUserOption("Log in as a Nursing Home User.");
        } else if (source == nmenu3) {
        } else if (source == nmenu4) {
            GuiClass.exitMethod();
        } else if (source == whoWebpage) {
            GuiClass.managingWebsitesByUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019?gclid=CjwKCAiAoOz-BRBdEiwAyuvA6zFm_6xmeRNPWgGQNFVbY-QYvGsIiJp2f6AClAZZk5DVurBchs0KMxoCinsQAvD_BwE");
        } else if (source == eodyWebpage) {
            GuiClass.managingWebsitesByUrl("https://eody.gov.gr/");
        } else if (source == emailAd) {
            GuiClass.contactUs();
        } else if (source == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c");
        } else if (source == Problems) {
            GuiClass.sendingProblem();
        } else if (source == Exit) {
            GuiClass.exitMethod();
        }

    }

    public static void managingWebsitesByUrl(String url) {
        try {
            d.browse(new URI(url));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (URISyntaxException uriSyntaxException) {
            uriSyntaxException.printStackTrace();
        }
    }

    public static void alreadyUserOption(String anyString) {
        LogOrg frame = new LogOrg();
        frame.setTitle(anyString);//this is how we will give different Titles for each occasion
        frame.setVisible(true);

        frame.setBounds(620, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public static void sendingProblem() {
        String problemDescription = (String) JOptionPane.showInputDialog("Please describe your problem in order to fix it");
        try {


            JavaMailUtil.sendMail("booleanshipproblems@gmail.com", "Problem", problemDescription);
            JOptionPane.showMessageDialog(null, "Our team will do the best in order to solve your problem as soon as possible!");
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.Please try again.");
        }
    }

    public static void contactUs() {
        String contactDescription = (String) JOptionPane.showInputDialog("Please write us your message!");
        String usersMail = (String) JOptionPane.showInputDialog("Please write your mail in order to receive our answer.");
        try {
            JavaMailUtil.sendMail(usersMail, "Message", "We received your message and we will reply as soon as possible!Thank you for using our app and stay safe.");
            JOptionPane.showMessageDialog(null, "Our team received your message and will answer as soon as possible!");
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An error occurred please check if your connection is good and if your email is right.");
        }
        try {
            JavaMailUtil.sendMail("booleanshipproblems@gmail.com", "ContactUsMessage", contactDescription);
            JOptionPane.showMessageDialog(null, "Our team received your message and will answer as soon as possible!");
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.Please try again.");
        }
    }

    public static void exitMethod() {
        GuiClass.managingWebsitesByUrl("https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/");
        System.exit(0);
    }

}



