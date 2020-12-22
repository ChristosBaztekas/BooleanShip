import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static java.awt.Font.PLAIN;
public class GuiClass extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar mainApp = new JMenuBar();
    private JMenu allmenus = new JMenu("All Menus Available");
    private JMenu useFullWebsitesAboutCovid = new JMenu("Usefull Websites about covid");
    private JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");
    private JMenuItem eodyWebpage = new JMenuItem("Eody webpage");
    private JMenuItem whoWebpage = new JMenuItem("World Health Organisation webpage");
    private JMenuItem emailAd = new JMenuItem("Email address");
    public JMenu help = new JMenu("Help");
    public JMenu contactUs = new JMenu("Contact us");
    public JMenu rateUs1 = new JMenu("Rate us");
    public JMenu exitm = new JMenu("Close Program");

    private JMenu menu1 = new JMenu("Goverment Menu");
    private JMenu menu2 = new JMenu("Labor Menu");
    private JMenu menu3 = new JMenu("School Menu");
    private JMenu menu4 = new JMenu("University Menu");
    private JMenu menu5 = new JMenu("Nursing home Menu");
    private JMenu menu6 = new JMenu("Exit");

    private JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");
    private JMenu rateUs = new JMenu("Rate us");

    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");

    private JMenuItem latestProtocolsl = new JMenuItem("Latest Protocols for the Labors category.");
    private JMenuItem latestProtocolss = new JMenuItem("Latest Protocols for the School category.");
    private JMenuItem latestProtocolsu = new JMenuItem("Latest Protocols for the University category.");
    private JMenuItem latestProtocolsn = new JMenuItem("Latest Protocols for the Nursing Home category.");
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
        	add(background);
        	setVisible(true);
        mainApp.add(allmenus);
        mainApp.add(useFullWebsitesAboutCovid);
        mainApp.add(help);
        mainApp.add(contactUs);
        mainApp.add(justExit);
        mainApp.add(rateUs1);
        mainApp.add(exitm);
        exitm.add(Exit);
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
        rateUs1.add(helpUsBecomeBetter);
        help.add(frequentlyAskedQuestions);
        menu2.add(lmenu1);
        menu2.add(lmenu2);
        menu2.add(lmenu3);
        menu2.add(latestProtocolsl);
        menu2.add(lmenu4);


        menu1.add(gmenu);

        menu1.add(gmenu5);


        menu3.add(smenu1);
        menu3.add(smenu2);
        menu3.add(smenu3);
        menu3.add(latestProtocolss);
        menu3.add(smenu4);

        menu4.add(umenu1);
        menu4.add(umenu2);
        menu4.add(umenu3);
        menu4.add(latestProtocolsu);
        menu4.add(umenu4);

        menu5.add(nmenu1);
        menu5.add(nmenu2);
        menu5.add(nmenu3);
        menu5.add(latestProtocolsn);
        menu5.add(nmenu4);


        menu6.add(justExit);
        Exit.addActionListener(this);
        helpUsBecomeBetter.addActionListener(this);
        latestProtocolsl.addActionListener(this);
        latestProtocolsu.addActionListener(this);
        latestProtocolsn.addActionListener(this);
        latestProtocolss.addActionListener(this);

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
        //JOptionPane.showMessageDialog(this, "Hi");
        Object source = e.getSource();
        if (source == justExit) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);

        } else if (source == gmenu) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Surveillance login form");
            alreadyUserOption("Log in as a Surveillance User");
        /*} else if (source == gmenu1) {
        } else if (source == gmenu2) {
        } else if (source == gmenu3) {
        } else if (source == gmenu4) {*/
        } else if (source == gmenu5) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == lmenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for public services and companies authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == lmenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Labor user login form");
            alreadyUserOption("Log in as a Labor User.");
        } else if (source == lmenu3) {
        } else if (source == lmenu4) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == smenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for School authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == smenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the School login form");
            alreadyUserOption("Log in as a School User.");
        } else if (source == smenu3) {
        } else if (source == smenu4) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == umenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for university authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == umenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the University login form");
            alreadyUserOption("Log in as a University User.");
        } else if (source == umenu3) {

        } else if (source == umenu4) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == nmenu1) {
            JOptionPane.showMessageDialog(null, "This is menu for Nursing home authorized users.If you are a new user sign in and then log in with the name and password you inserted for more information about the usage of the app.");
        } else if (source == nmenu2) {
            dispose();
            JOptionPane.showMessageDialog(this, "Redirecting to the Nursing Home login form");
            alreadyUserOption("Log in as a Nursing Home User.");
        } else if (source == nmenu3) {
        } else if (source == nmenu4) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == whoWebpage) {
            try {
                d.browse(new URI(
                        "https://www.who.int/emergencies/diseases/novel-coronavirus-2019?gclid=CjwKCAiAoOz-BRBdEiwAyuvA6zFm_6xmeRNPWgGQNFVbY-QYvGsIiJp2f6AClAZZk5DVurBchs0KMxoCinsQAvD_BwE"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == eodyWebpage) {

            try {
                d.browse(new URI(
                        "https://eody.gov.gr/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == emailAd) {
            JOptionPane.showMessageDialog(null, "Our mail is BooleanShip@gmail.com feel free to contact us!");
        } else if (source == latestProtocolsl) {
            try {
                d.browse(new URI(
                        "https://eody.gov.gr/"));//input here a url that leads to the latest protocol website
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == latestProtocolsn) {
            try {
                d.browse(new URI(
                        "https://eody.gov.gr/"));//input here a url that leads to the latest protocol website
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == latestProtocolss) {
            try {
                d.browse(new URI(
                        "https://eody.gov.gr/"));//input here a url that leads to the latest protocol website
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == latestProtocolsu) {
            try {
                d.browse(new URI(
                        "https://eody.gov.gr/"));//input here a url that leads to the latest protocol website
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == helpUsBecomeBetter) {
            try {
                d.browse(new URI(
                        "https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == Problems) {
            try {
                d.browse(new URI(
                        "https://www.surveymonkey.com/r/2WKC6MB"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (source == Exit) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
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

}
