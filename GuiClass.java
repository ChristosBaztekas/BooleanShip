import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.ArrayList;

import static java.awt.Font.*;


public class GuiClass extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar mainApp = new JMenuBar();
    private JLabel displayLabel, displayLabel2, displayLabel3;
    private JMenu allmenus = new JMenu("All Menus Available");
    private JMenu useFullWebsitesAboutCovid = new JMenu("Usefull Websites about covid");
    private JMenu help = new JMenu("Help");
    private JMenu contactUs = new JMenu("Contact us");

    private JMenuItem eodyWebpage = new JMenuItem("Eody webpage");
    private JMenuItem whoWebpage = new JMenuItem("World Health Organisation webpage");
    private JMenuItem emailAd = new JMenuItem("Email address");

    private JMenu menu1 = new JMenu("Goverment Menu");
    private JMenu menu2 = new JMenu("Labor Menu");
    private JMenu menu3 = new JMenu("School Menu");
    private JMenu menu4 = new JMenu("University Menu");
    private JMenu menu5 = new JMenu("Nursing home Menu");
    private JMenu menu6 = new JMenu("Exit");

    private JMenu rateUs = new JMenu("Rate us");

    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");

    private JMenuItem latestProtocolsl = new JMenuItem("Latest Protocols for the Labors category.");
    private JMenuItem latestProtocolss = new JMenuItem("Latest Protocols for the School category.");
    private JMenuItem latestProtocolsu = new JMenuItem("Latest Protocols for the University category.");
    private JMenuItem latestProtocolsn = new JMenuItem("Latest Protocols for the Nursing Home category.");

    private JMenuItem justExit = new JMenuItem("Exit");
    private JMenuItem gmenu = new JMenuItem("Menu and info are not available for not authorized users");
    private JMenuItem gmenu1 = new JMenuItem("See all registered organizations");
    private JMenuItem gmenu2 = new JMenuItem("See the latest statistics on the pandemic");
    private JMenuItem gmenu3 = new JMenuItem("See all recorded case contacts");
    private JMenuItem gmenu4 = new JMenuItem("See cases by regions");
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


    //private Organisations Eody = new Organisations("Eody", "Marousi",200 );


    public GuiClass() {
        setLayout(new FlowLayout());
        setJMenuBar(mainApp);
        displayLabel = new JLabel("Welcome to the app of case detection and contact detection!");
        displayLabel2 = new JLabel("The application is designed to make it easier for all organisations to manage the pandemic.");
        displayLabel3 = new JLabel("Data access and analysis will only be for the provision of statistical data and for the purpose of limiting the spread of.");
        displayLabel.setFont(new Font("Serif",
                PLAIN,
                30));
        displayLabel2.setFont(new Font("Serif",
                PLAIN,
                30));
        displayLabel3.setFont(new Font("Serif",
                PLAIN,
                30));
        getContentPane().setBackground(Color.gray);
        add(displayLabel, BorderLayout.CENTER);
        add(displayLabel2, BorderLayout.CENTER);
        add(displayLabel3, BorderLayout.CENTER);
        mainApp.add(allmenus);
        mainApp.add(useFullWebsitesAboutCovid);
        mainApp.add(help);
        mainApp.add(contactUs);
        mainApp.add(justExit);
        mainApp.add(rateUs);
        useFullWebsitesAboutCovid.add(whoWebpage);
        useFullWebsitesAboutCovid.add(eodyWebpage);
        contactUs.add(emailAd);
        mainApp.setSize(700, 700);
        allmenus.add(menu1);
        allmenus.add(menu2);
        allmenus.add(menu3);
        allmenus.add(menu4);
        allmenus.add(menu5);
        allmenus.add(menu6);
        rateUs.add(helpUsBecomeBetter);

        menu2.add(lmenu1);
        menu2.add(lmenu2);
        menu2.add(lmenu3);
        menu2.add(latestProtocolsl);
        menu2.add(lmenu4);


        menu1.add(gmenu);
        /*menu1.add(gmenu1);
        menu1.add(gmenu2);
        menu1.add(gmenu3);
        menu1.add(gmenu4);*/
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
        helpUsBecomeBetter.addActionListener(this);
        latestProtocolsl.addActionListener(this);
        latestProtocolsu.addActionListener(this);
        latestProtocolsn.addActionListener(this);
        latestProtocolss.addActionListener(this);

        contactUs.addActionListener(this);
        eodyWebpage.addActionListener(this);
        whoWebpage.addActionListener(this);
        justExit.addActionListener(this);
        emailAd.addActionListener(this);

        gmenu.addActionListener(this);
        /*gmenu1.addActionListener(this);
        gmenu2.addActionListener(this);
        gmenu3.addActionListener(this);
        gmenu4.addActionListener(this);*/
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
            alreadyUserOption("Log in as a Surveilence User.");
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
        }else if(source == helpUsBecomeBetter){
            try {
                d.browse(new URI(
                        "https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }

    }

    public static void alreadyUserOption(String anyString) {
        LogOrg frame = new LogOrg();
        frame.setTitle(anyString);//this is how we will give different Titles for each occasion
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
    }

}


