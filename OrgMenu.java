package com.Gui.BooleanShip;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OrgMenu extends JFrame implements ActionListener {
    static Desktop d = Desktop.getDesktop();
    private JMenuBar controlGovMenu = new JMenuBar();

    private JMenu mainMenug = new JMenu("User Surveillance Menu.");
    private JMenu help = new JMenu("Help");
    private JMenu contactUs = new JMenu("Contact us");
    private JMenu rateUs = new JMenu("Rate us");
    private JMenu exitm = new JMenu("Close Program");
    private JMenu emergencyContact = new JMenu("Emergency contact");
    private JMenu frequentlyAskedQuestions = new JMenu("Frequently asked questions");

    private JMenuItem phone = new JMenuItem("Phone number for emergency");
    private JMenuItem Problems = new JMenuItem("Please describe if you encountered any problem");//Dont forget to create a new surveyMonkey
    private JMenuItem helpUsBecomeBetter = new JMenuItem("Help us become better");
    private JMenuItem emailAd = new JMenuItem("Email address");

    private JMenuItem i1 = new JMenuItem("All registered organizations");
    private JMenuItem i2 = new JMenuItem("Latest statistics on the pandemic");
    private JMenuItem i3 = new JMenuItem("All recorded case");
    private JMenuItem i4 = new JMenuItem("All Contacts recorder");
    private JMenuItem i5 = new JMenuItem("All test Results");
    private JMenuItem i6 = new JMenuItem("Cases by regions");
    private JMenuItem i7 = new JMenuItem("Send email to all registered Organisations");
    private JMenuItem exit = new JMenuItem("Exit");
    private JMenuItem close = new JMenuItem("Exit");

    public OrgMenu() {
        setLayout(new FlowLayout());
        setJMenuBar(controlGovMenu);
        controlGovMenu.add(mainMenug);
        controlGovMenu.add(help);
        controlGovMenu.add(contactUs);
        controlGovMenu.add(rateUs);
        controlGovMenu.add(exitm);
        exitm.add(close);
        mainMenug.add(i1);
        mainMenug.add(i2);
        mainMenug.add(i3);
        mainMenug.add(i4);
        mainMenug.add(i5);
        mainMenug.add(i6);
        mainMenug.add(i7);



        mainMenug.add(exit);
        help.add(frequentlyAskedQuestions);
        help.add(Problems);
        rateUs.add(helpUsBecomeBetter);
        contactUs.add(emailAd);
        contactUs.add(emergencyContact);
        emergencyContact.add(phone);

        Problems.addActionListener(this);
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
            JOptionPane.showMessageDialog(this, "Read the code it is easy!!");
        } else if (e.getSource() == i2) {

        } else if (e.getSource() == i3) {

        } else if (e.getSource() == i4) {

        } else if (e.getSource() == i5) {

        } else if (e.getSource() == i6) {

        }else if (e.getSource() == i7) {
            String subject = (String)JOptionPane.showInputDialog("Input subject");
            String mainText = (String)JOptionPane.showInputDialog("Input main text");
            try {
                JavaMailUtil.sendMail("leonidasdiam2001@gmail.com",subject,mainText);
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }

        }  else if (e.getSource() == exit) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);
        } else if (e.getSource() == close) {
            try {
                d.browse(new URI(
                        "https://www.greece-is.com/news/till-staysafe-marketing-greeces-campaign-hope/"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
            System.exit(0);

        }else if (e.getSource() == phone) {
            JOptionPane.showMessageDialog(null, "Only in case of emergency feel free to contact us any time in 6983461347!");
        }else if (e.getSource() == helpUsBecomeBetter) {
            try {
                d.browse(new URI(
                        "https://www.surveymonkey.com/r/P27WNXW?fbclid=IwAR2_xQOVHzHm2XBVTwzjiAq7AXpHp8vQqSd7c9kNEEmp8G7k5YIzgB5On_c"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }else if (e.getSource() == emailAd) {
            JOptionPane.showMessageDialog(null, "Our mail is BooleanShip@gmail.com feel free to contact us!");
        }else if(e.getSource() == Problems){
            try {
                d.browse(new URI(
                        "https://www.surveymonkey.com/r/2WKC6MB"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }

    }
}

