package covid.app.gui.bool.ship.mainMenu;

import covid.app.data.dao.DaoImpl;
import covid.app.data.model.Human;
import covid.app.gui.bool.ship.login.*;
import covid.app.gui.bool.ship.registrationForms.RegistrationFormL;
import covid.app.gui.bool.ship.registrationForms.RegistrationFormNh;
import covid.app.gui.bool.ship.registrationForms.RegistrationFormS;
import covid.app.gui.bool.ship.registrationForms.RegistrationFormU;
import covid.app.manager.DBConnectionManager;
import org.apache.commons.validator.routines.EmailValidator;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;


public class GuiClass extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private final JMenuItem eodyWebpage = new JMenuItem("Eody webpage");
    private final JMenuItem whoWebpage = new JMenuItem("World Health Organisation webpage");
    private final JMenuItem covidC = new JMenuItem("(COVID-19) Cases, Data, and Surveillance");
    private final JMenuItem nih = new JMenuItem("National Institutes of Health");
    private final JMenuItem nhs = new JMenuItem("Covid advices from NHS");
    private final JMenuItem cStats = new JMenuItem("Covid worldwide cases");


    private final JMenuItem emailAd = new JMenuItem("Email address");

    private final JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");

    private final JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");


    private final JMenuItem Exit = new JMenuItem("Close Program");
    private final JMenuItem justExit = new JMenuItem("Exit");
    private final JMenuItem gmenu = new JMenuItem("Menu and info are not available for not authorized users");

    private final JMenuItem gmenu5 = new JMenuItem("Exit");

    private final JMenuItem nmenu1 = new JMenuItem("Info about this menu");
    private final JMenuItem nmenu2 = new JMenuItem("User menu");
    private final JMenuItem nmenu3 = new JMenuItem("Sign up");
    private final JMenuItem nmenu4 = new JMenuItem("Exit");

    private final JMenuItem smenu1 = new JMenuItem("Info about this menu");
    private final JMenuItem smenu2 = new JMenuItem("User menu");
    private final JMenuItem smenu3 = new JMenuItem("Sign up");
    private final JMenuItem smenu4 = new JMenuItem("Exit");

    private final JMenuItem umenu1 = new JMenuItem("Info about this menu");
    private final JMenuItem umenu2 = new JMenuItem("User menu");
    private final JMenuItem umenu3 = new JMenuItem("Sign up");
    private final JMenuItem umenu4 = new JMenuItem("Exit");

    private final JMenuItem lmenu1 = new JMenuItem("Info about this menu");
    private final JMenuItem lmenu2 = new JMenuItem("User menu");
    private final JMenuItem lmenu3 = new JMenuItem("Sign up");
    private final JMenuItem lmenu4 = new JMenuItem("Exit");


    public GuiClass() {
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("D:\\CovidApp\\src\\CovidApp\\Gui\\BooleanShip\\covid-19.png")));
        setLayout(new FlowLayout());


        JMenuBar mainApp = new JMenuBar();
        setJMenuBar(mainApp);
        mainApp.setBackground(Color.WHITE);
        JMenu allmenus = new JMenu("All Menus Available");
        mainApp.add(allmenus);
        JMenu useFullWebsitesAboutCovid = new JMenu("Useful Websites about covid");
        mainApp.add(useFullWebsitesAboutCovid);
        JMenu help = new JMenu("Help");
        mainApp.add(help);
        JMenu contactUs = new JMenu("Contact us");
        mainApp.add(contactUs);
        mainApp.add(justExit);
        JMenu rateUs = new JMenu("Rate us");
        mainApp.add(rateUs);
        JMenu exitMenu = new JMenu("Exit");
        mainApp.add(exitMenu);
        exitMenu.add(Exit);
        help.add(Problems);
        useFullWebsitesAboutCovid.add(whoWebpage);
        useFullWebsitesAboutCovid.add(eodyWebpage);
        useFullWebsitesAboutCovid.add(covidC);
        useFullWebsitesAboutCovid.add(nih);
        useFullWebsitesAboutCovid.add(nhs);
        useFullWebsitesAboutCovid.add(cStats);
        contactUs.add(emailAd);
        mainApp.setSize(800, 800);
        JMenu menu1 = new JMenu("Government Menu");
        allmenus.add(menu1);
        JMenu menu2 = new JMenu("Labor Menu");
        allmenus.add(menu2);
        JMenu menu3 = new JMenu("School Menu");
        allmenus.add(menu3);
        JMenu menu4 = new JMenu("University Menu");
        allmenus.add(menu4);
        JMenu menu5 = new JMenu("Nursing home Menu");
        allmenus.add(menu5);
        JMenu menu6 = new JMenu("Exit");
        allmenus.add(menu6);
        rateUs.add(helpUsBecomeBetter);
        JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
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
        nih.addActionListener(this);
        nhs.addActionListener(this);
        cStats.addActionListener(this);
        Problems.addActionListener(this);
        contactUs.addActionListener(this);
        eodyWebpage.addActionListener(this);
        covidC.addActionListener(this);
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
            JOptionPane.showMessageDialog(this, "Redirecting to the Surveillance login form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            alreadyUserOptionG("Log in as a Surveillance User");
        } else if (source == gmenu5) {
            GuiClass.exitMethod();
        } else if (source == lmenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for public services and companies authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == lmenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Labor user login form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            alreadyUserOptionL("Log in as a Labor User");
        } else if (source == lmenu3) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Labor user registration form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            RegistrationFormL wsFrame = new RegistrationFormL();
            wsFrame.setBounds(400, 100, 800, 450);
            wsFrame.setTitle("Welcome to the Labor user register form");
            wsFrame.setVisible(true);
            wsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else if (source == lmenu4) {
            GuiClass.exitMethod();
        } else if (source == smenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for School authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == smenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the School login form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            alreadyUserOptionS("Log in as a School User");
        } else if (source == smenu3) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the School user registration form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            RegistrationFormS wsFrame = new RegistrationFormS();
            wsFrame.setBounds(400, 100, 800, 450);
            wsFrame.setTitle("Welcome to the School User registration form");
            wsFrame.setVisible(true);
            wsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else if (source == smenu4) {
            GuiClass.exitMethod();
        } else if (source == umenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for university authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == umenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the University login form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            alreadyUserOptionU("Log in as a University User.");
        } else if (source == umenu3) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the University user registration form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            RegistrationFormU wsFrame = new RegistrationFormU();
            wsFrame.setBounds(400, 100, 800, 450);
            wsFrame.setTitle("Welcome to the University User registration form");
            wsFrame.setVisible(true);
            wsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else if (source == umenu4) {
            GuiClass.exitMethod();
        } else if (source == nmenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for Nursing home authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == nmenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Nursing Home login form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            alreadyUserOptionN("Log in as a Nursing Home User");
        } else if (source == nmenu3) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Nursing Home user registration form", "Redirection", JOptionPane.INFORMATION_MESSAGE);
            RegistrationFormNh wsFrame = new RegistrationFormNh();
            wsFrame.setBounds(400, 100, 800, 450);
            wsFrame.setTitle("Welcome to the Nursing Home User registration form");
            wsFrame.setVisible(true);
            wsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        } else if (source == nmenu4) {
            GuiClass.exitMethod();
        } else if (source == whoWebpage) {
            GuiClass.managingWebsitesByUrl("https://www.who.int/emergencies/diseases/novel-coronavirus-2019?gclid=CjwKCAiAoOz-BRBdEiwAyuvA6zFm_6xmeRNPWgGQNFVbY-QYvGsIiJp2f6AClAZZk5DVurBchs0KMxoCinsQAvD_BwE");
        } else if (source == eodyWebpage) {
            GuiClass.managingWebsitesByUrl("https://eody.gov.gr/");
        } else if (source == emailAd) {
            GuiClass.contactUs();
        } else if (source == helpUsBecomeBetter) {
            GuiClass.managingWebsitesByUrl("https://www.surveymonkey.com/r/KBZMGD7?fbclid=IwAR2rdWZjoMw8uVfKraFLN5LsOnM4pGDoRcf3FOkcWCghsKfEk-KdAVoYxNo");
        } else if (source == Problems) {
            GuiClass.sendingProblem();
        } else if (source == Exit) {
            GuiClass.exitMethod();
        } else if (source == covidC) {
            GuiClass.managingWebsitesByUrl("https://www.cdc.gov/coronavirus/2019-ncov/cases-updates/index.html");
        } else if (source == nih) {
            GuiClass.managingWebsitesByUrl("https://covid19.nih.gov/");
        } else if (source == nhs) {
            GuiClass.managingWebsitesByUrl("https://www.bhamcommunity.nhs.uk/");
        } else if (source == cStats) {

            GuiClass.managingWebsitesByUrl("https://www.arcgis.com/apps/opsdashboard/index.html#/bda7594740fd40299423467b48e9ecf6");
        }

    }

    public static void managingWebsitesByUrl(String url) {
        try {
            d.browse(new URI(url));
        } catch (IOException | URISyntaxException ioException) {
            ioException.printStackTrace();
        }
    }


    public static void alreadyUserOptionG(String anyString) {
        LogOrg frame = new LogOrg();
        frame.setTitle(anyString);//this is how we will give different Titles for each occasion
        frame.setVisible(true);
        frame.setBounds(620, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public static void alreadyUserOptionN(String anyString) {
        LogNursingHome frame = new LogNursingHome();
        frame.setTitle(anyString);
        frame.setVisible(true);
        frame.setBounds(620, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public static void alreadyUserOptionS(String anyString) {
        LogSchool frame = new LogSchool();
        frame.setTitle(anyString);
        frame.setVisible(true);
        frame.setBounds(620, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public static void alreadyUserOptionU(String anyString) {
        LogUniversity frame = new LogUniversity();
        frame.setTitle(anyString);
        frame.setVisible(true);
        frame.setBounds(620, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public static void alreadyUserOptionL(String anyString) {
        LogLabor frame = new LogLabor();
        frame.setTitle(anyString);
        frame.setVisible(true);
        frame.setBounds(620, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

    public static void sendingProblem() {
        String problemDescription = JOptionPane.showInputDialog("Please describe your problem in order to fix it");
        try {


            JavaMailUtil.sendMail("booleanshipproblems@gmail.com", "Problem", problemDescription);
            JOptionPane.showMessageDialog(null, "Our team will do the best in order to solve your problem as soon as possible!");
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.Please try again.");
        }
    }

    public static void contactUs() {
        String contactDescription = JOptionPane.showInputDialog("Please write us your message!");
        String usersMail = JOptionPane.showInputDialog("Please write your mail in order to receive our answer.");
        try {
            isValidEmail(usersMail);
            JavaMailUtil.sendMail(usersMail, "Message", "We received your message and we will reply as soon as possible!Thank you for using our app and stay safe.");
            try {
                JavaMailUtil.sendMail("booleanshipproblems@gmail.com", "ContactUsMessage", contactDescription);
                JOptionPane.showMessageDialog(null, "Our team received your message and will answer as soon as possible!", "Message received", JOptionPane.INFORMATION_MESSAGE);
            } catch (MessagingException messagingException) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An error occurred please check if your connection is good and if your email is right.", "Erroe", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void exitMethod() {
        GuiClass.managingWebsitesByUrl("https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/");
        System.exit(0);
    }


    public static Boolean isValidAfm(String afm) {

        int len = afm.length();

        if (len != 9) {
            JOptionPane.showMessageDialog(null, "The afm should contain 9 characters.Please try again.", "Invalid number of characters", JOptionPane.ERROR_MESSAGE);

            return false;

        } else {
            for (int i = 0; i < 9; i++) {
                if (afm.charAt(i) < '0' || afm.charAt(i) > '9') {
                    JOptionPane.showMessageDialog(null, "The afm should contain only numbers.Please try again.", "Invalid input", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "The email is not right.Please try again", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static void createContact(String afm) {
        if (JOptionPane.showConfirmDialog(null, "Do you have contacts of the case declared?", "Contacts", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String ans_afm = JOptionPane.showInputDialog("Please write the contact's afm");
            if (GuiClass.isValidAfm(ans_afm)) {
                String name, surname, email;
                JPanel panel = new JPanel(new GridLayout(4, 1));
                JLabel lname = new JLabel("Name");
                lname.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel lsurname = new JLabel("Surname");
                lsurname.setFont(new Font("Arial", Font.BOLD, 18));

                JLabel lemail = new JLabel("Email");
                lemail.setFont(new Font("Arial", Font.BOLD, 18));

                JTextField tname = new JTextField();

                JTextField tsurname = new JTextField();


                JRadioButton male = new JRadioButton("male");
                JRadioButton female = new JRadioButton("female");


                JTextField temail = new JTextField();
                temail.setSize(0, 0);
                tname.setSize(0, 0);
                tsurname.setSize(0, 0);
                panel.add(lname);
                panel.add(tname);
                panel.add(lsurname);
                panel.add(tsurname);

                panel.add(lemail);
                panel.add(temail);
                panel.add(male);
                panel.add(female);


                JOptionPane.showMessageDialog(null, panel, "Contact's" + " additional info", JOptionPane.PLAIN_MESSAGE);
                name = tname.getText();
                surname = tsurname.getText();
                email = temail.getText();
                if (email != null) {
                    GuiClass.isValidEmail(email);
                }
                if (male.isSelected()) {
                    try {
                        Human one = new Human(name, surname, ans_afm, email, "male", "Contact", "Contact");
                        DBConnectionManager manager = new DBConnectionManager();
                        DaoImpl impl = new DaoImpl(manager);
                        impl.declareContacts(one, afm);
                        try {
                            JavaMailUtil.sendMail(email, "Contact", "You have come in contact with a covid case please speak with your doctor and do not meet other people until you ensure that you do not have covid.Stay Safe!");
                            JOptionPane.showMessageDialog(null, "The contact was successfully added", "Completed", JOptionPane.INFORMATION_MESSAGE);
                        } catch (MessagingException e) {
                            JOptionPane.showMessageDialog(null, "Something unexpected happened.Please Try again", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IllegalAccessException e) {
                        JOptionPane.showMessageDialog(null, "Something unexpected happened.Please Try again", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else if (female.isSelected()) {
                    try {
                        Human one = new Human(name, surname, ans_afm, email, "female", "Contact", "Contact");
                        DBConnectionManager manager = new DBConnectionManager();
                        DaoImpl impl = new DaoImpl(manager);
                        impl.declareContacts(one, afm);
                        try {
                            JavaMailUtil.sendMail(email, "Contact", "You have come in contact with a covid case please speak with your doctor and do not meet other people until you ensure that you do not have covid.Stay Safe!");
                            JOptionPane.showMessageDialog(null, "The contact was successfully added", "Completed", JOptionPane.INFORMATION_MESSAGE);
                        } catch (MessagingException e) {
                            JOptionPane.showMessageDialog(null, "Something unexpected happened.Please Try again", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IllegalAccessException e) {
                        JOptionPane.showMessageDialog(null, "Something unexpected happened.Please Try again", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please find contacts immediately and add them via the menu option");
            }

        }
    }

    public static void createHumans(String typeOfHuman, String orgType, String role, String orgUsername) {
        Human one;

        String ans_afm = JOptionPane.showInputDialog("Please write the " + typeOfHuman + "'s afm");

        if (GuiClass.isValidAfm(ans_afm)) {
            int pos = Human.search(ans_afm);
            if (pos == -1) {
                String name, surname, email;
                JPanel panel = new JPanel(new GridLayout(4, 1));
                JLabel lname = new JLabel("Name");
                lname.setFont(new Font("Arial", Font.BOLD, 18));
                JLabel lsurname = new JLabel("Surname");
                lsurname.setFont(new Font("Arial", Font.BOLD, 18));

                JLabel lemail = new JLabel("Email");
                lemail.setFont(new Font("Arial", Font.BOLD, 18));

                JTextField tname = new JTextField();

                JTextField tsurname = new JTextField();


                JRadioButton male = new JRadioButton("male");
                JRadioButton female = new JRadioButton("female");


                JTextField temail = new JTextField();
                temail.setSize(0, 0);
                tname.setSize(0, 0);
                tsurname.setSize(0, 0);
                panel.add(lname);
                panel.add(tname);
                panel.add(lsurname);
                panel.add(tsurname);

                panel.add(lemail);
                panel.add(temail);
                panel.add(male);
                panel.add(female);


                JOptionPane.showMessageDialog(null, panel, typeOfHuman + " additional info", JOptionPane.PLAIN_MESSAGE);
                name = tname.getText();
                surname = tsurname.getText();
                email = temail.getText();


                if (name.equals("") || surname.equals("") || email.equals("")) {
                    JOptionPane.showMessageDialog(null, "All sections should Contain something process failed.Please Try again", "Content Missing", JOptionPane.ERROR_MESSAGE);
                    GuiClass.createHumans(typeOfHuman, orgType, role, orgUsername);
                } else {
                    if (!GuiClass.isValidEmail(email)) {
                        GuiClass.createHumans(typeOfHuman, orgType, role, orgUsername);
                    } else {

                        try {
                            if (male.isSelected()) {
                                one = new Human(name, surname, ans_afm, email, "male", orgType, role);
                                GuiClass.registrationEmployeeAutomatedMail(email);
                                DBConnectionManager manager = new DBConnectionManager();
                                DaoImpl impl = new DaoImpl(manager);
                                impl.insertHuman(one, orgUsername);
                            } else if (female.isSelected()) {
                                one = new Human(name, surname, ans_afm, email, "female", orgType, role);
                                GuiClass.registrationEmployeeAutomatedMail(email);
                                DBConnectionManager manager = new DBConnectionManager();
                                DaoImpl impl = new DaoImpl(manager);
                                impl.insertHuman(one, orgUsername);

                            }


                        } catch (IllegalAccessException iAe) {
                            JOptionPane.showMessageDialog(null, "Something unexpected happened.Please Try again", "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "The afm already exists.Please Try again", "Already existed afm", JOptionPane.ERROR_MESSAGE);
                GuiClass.createHumans(typeOfHuman, orgType, role, orgUsername);
            }
        }
    }

    public static void registrationAutomatedMail(String orgMail) {
        try {
            JavaMailUtil.sendMail(orgMail, "Welcome", "Thank you for registering on our app.If you have any problem feel free to contact us. ");
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An error occurred please check if your connection is good and if your email is right.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void registrationEmployeeAutomatedMail(String mail) {
        try {
            JavaMailUtil.sendMail(mail, "Welcome", "We will like to inform you that the organisation you belong just registered you as a member.We will help you if you encounter any covid related problem.If you have any problem feel free to contact us. ");
        } catch (MessagingException messagingException) {
            JOptionPane.showMessageDialog(null, "An error occurred please check if your connection is good and if your email is right.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void inputAdditionalContacts() {
        String ans_afm = JOptionPane.showInputDialog("Please write the afm of the case that the contact you want to declare is related");

        if (GuiClass.isValidAfm(ans_afm)) {
            DBConnectionManager manager = new DBConnectionManager();
            DaoImpl impl2 = new DaoImpl(manager);
            if (impl2.findHumanFromAfm(ans_afm)) {
                GuiClass.createContact(ans_afm);
            }
        }
    }

    public static void orgStatus(String orgName) {
        DBConnectionManager manager = new DBConnectionManager();
        DaoImpl impl = new DaoImpl(manager);
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel cases = new JLabel("Cases: " + impl.countCases(orgName));
        cases.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel members = new JLabel("Members of your org: " + impl.countMembers(orgName));
        members.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel quarantine = new JLabel("Would you like to set quarantine mode?");
        quarantine.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel empty = new JLabel("");
        quarantine.setFont(new Font("Arial", Font.BOLD, 20));
        JRadioButton yes = new JRadioButton("Yes");
        JRadioButton no = new JRadioButton("No");
        if ((impl.countMembers(orgName) * 0.1) < impl.countCases(orgName)) {
            JOptionPane.showMessageDialog(null, "Cases are more than the 10% of your total member we suggest you to select quarantine mode and conduct as many activities as possible online.", "Quarantine alert", JOptionPane.PLAIN_MESSAGE);
        }

        panel.add(cases);
        panel.add(members);
        panel.add(quarantine);
        panel.add(empty);
        panel.add(yes);
        panel.add(no);
        JOptionPane.showMessageDialog(null, panel, "Status of your organisation", JOptionPane.PLAIN_MESSAGE);
        if (yes.isSelected()) {
            JOptionPane.showMessageDialog(null, "Quarantine mode activated.Please inform via the massive email option the new regulations you are going to set ", "Quarantine mode", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static String getRandomNumberString() {

        Random rnd = new Random();
        int number = rnd.nextInt(999999);


        return String.format("%06d", number);
    }

    public Boolean registrationCode(String mail) {
        DBConnectionManager manager = new DBConnectionManager();
        DaoImpl impl = new DaoImpl(manager);
        String sixdig = impl.createAuthCode(mail, true);
        try {
            JavaMailUtil.sendMail(mail, "Registration code", "Your registration code is: " + sixdig + " If you did not register in our app ignore this mail");
            String usersSixDigit = JOptionPane.showInputDialog("Check your mail!Write as the six digits code in order to finish your registration");

            if (sixdig.equals(usersSixDigit)) {
                JOptionPane.showMessageDialog(null, "You verified your mail successfully");
                impl.disactivateAuthCode(mail, false);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "The code you inserted is false...You will be redirected to the main menu.");
                impl.disactivateAuthCode(mail, false);
                return false;
            }
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Something unexpected occurred.Try again or contact us by the suitable menu option.", "Unexpected error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

}




