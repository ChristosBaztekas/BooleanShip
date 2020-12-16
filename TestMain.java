import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class MainTest extends JFrame implements ActionListener {

    private JMenuBar mainApp = new JMenuBar();
    private JMenu menu1 = new JMenu("Goverment Menu");
    private JMenu menu2 = new JMenu("Labor Menu");
    private JMenu menu3 = new JMenu("School Menu");
    private JMenu menu4 = new JMenu("University Menu");
    private JMenu menu5 = new JMenu("Nursing home Menu");
    private JMenu menu6 = new JMenu("Exit");

    private JMenuItem gmenu = new JMenuItem("User Surveillance Menu.");
    private JMenuItem gmenu1 = new JMenuItem("See all registered organizations");
    private JMenuItem gmenu2 = new JMenuItem("See the latest statistics on the pandemic");
    private JMenuItem gmenu3 = new JMenuItem("See all recorded case contacts");
    private JMenuItem gmenu4 = new JMenuItem("See cases by regions");
    private JMenuItem gmenu5 = new JMenuItem("Exit");

    private JMenuItem nmenu1 = new JMenuItem("Welcome to the Nursing Homes user menu");
    private JMenuItem nmenu2 = new JMenuItem("User menu");
    private JMenuItem nmenu3 = new JMenuItem("Sign in");
    private JMenuItem nmenu4 = new JMenuItem("Exit");

    private JMenuItem smenu1 = new JMenuItem("Welcome to the School user menu");
    private JMenuItem smenu2 = new JMenuItem("User menu");
    private JMenuItem smenu3 = new JMenuItem("Sign in");
    private JMenuItem smenu4 = new JMenuItem("Exit");

    private JMenuItem umenu1 = new JMenuItem("Welcome to the University user menu");
    private JMenuItem umenu2 = new JMenuItem("User menu");
    private JMenuItem umenu3 = new JMenuItem("Sign in");
    private JMenuItem umenu4 = new JMenuItem("Exit");

    private JMenuItem lmenu1 = new JMenuItem("Welcome to the Labor user menu");
    private JMenuItem lmenu2 = new JMenuItem("User menu");
    private JMenuItem lmenu3 = new JMenuItem("Sign in");
    private JMenuItem lmenu4 = new JMenuItem("Exit");

    private JTextArea text = new JTextArea(20, 40);

    //private Organisations Eody = new Organisations("Eody", "Marousi",200 );

    public static void main(String[] args) {
        MainTest wsFrame = new MainTest();
        wsFrame.setSize(600, 600);
        wsFrame.setTitle("Welcome to the app of case detection and contact detection!");
        wsFrame.setVisible(true);
        wsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public MainTest() {
        setLayout(new FlowLayout());
        setJMenuBar(mainApp);
        mainApp.add(menu1);
        mainApp.add(menu2);
        mainApp.add(menu3);
        mainApp.add(menu4);
        mainApp.add(menu5);
        mainApp.add(menu6);

        menu1.add(gmenu);
        menu1.add(gmenu1);
        menu1.add(gmenu2);
        menu1.add(gmenu3);
        menu1.add(gmenu4);
        menu1.add(gmenu5);

        menu2.add(lmenu1);
        menu2.add(lmenu2);
        menu2.add(lmenu3);
        menu2.add(lmenu4);

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

        add(text);
        menu6.addActionListener(this);

        gmenu.addActionListener(this);
        gmenu1.addActionListener(this);
        gmenu2.addActionListener(this);
        gmenu3.addActionListener(this);
        gmenu4.addActionListener(this);
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
        if (source == menu6) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);

        } else if (source == gmenu) {
        } else if (source == gmenu1) {
        } else if (source == gmenu2) {

        } else if (source == gmenu3) {
        } else if (source == gmenu4) {
        } else if (source == gmenu5) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == lmenu1) {
        } else if (source == lmenu2) {
            LogOrg frame=new LogOrg();
            frame.setTitle("Login to your Organisation");//this is how we will give different Titles for each occasion
            frame.setVisible(true);
            frame.setBounds(10,10,370,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
        } else if (source == lmenu3) {
        } else if (source == lmenu4) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == smenu1) {
        } else if (source == smenu2) {
            LogOrg frame=new LogOrg();
            frame.setTitle("Login to your Organisation");//this is how we will give different Titles for each occasion
            frame.setVisible(true);
            frame.setBounds(10,10,370,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
        } else if (source == smenu3) {
        } else if (source == smenu4) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == umenu1) {
        } else if (source == umenu2) {
            LogOrg frame=new LogOrg();
            frame.setTitle("Login to your Organisation");//this is how we will give different Titles for each occasion
            frame.setVisible(true);
            frame.setBounds(10,10,370,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
        } else if (source == umenu3) {
        } else if (source == umenu4) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (source == nmenu1) {
        } else if (source == nmenu2) {
            LogOrg frame=new LogOrg();
            frame.setTitle("Login to your Organisation");//this is how we will give different Titles for each occasion
            frame.setVisible(true);
            frame.setBounds(10,10,370,600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(true);
        } else if (source == nmenu3) {
        } else if (source == nmenu4) {
            Desktop d = Desktop.getDesktop();
            try {
                d.browse(new URI(
                        "https://www.weinegg.com/en/cuisine/wine-store/29-0.html"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        }
    }
}
