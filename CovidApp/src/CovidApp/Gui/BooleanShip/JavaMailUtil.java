package CovidApp.Gui.BooleanShip;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public class JavaMailUtil extends JFrame {
    public static void sendMail(String usersMail,String subject,String mainText) throws MessagingException {
        JOptionPane.showMessageDialog(null, "Preparing to send mail.");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.post","587");

        String mail = "booleanship@gmail.com";
        String passwordB = "fixBugs1";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("booleanship@gmail.com","fixBugs1");
            }
        });

        Message message = prepareMessage(session,mail,usersMail,subject,mainText);

        Transport.send(message);

        JOptionPane.showMessageDialog(null, "Message sent successfully!");
    }

    private static Message prepareMessage(Session session, String mail,String usersMail,String subject,String mainText) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(usersMail));
            message.setSubject(subject);
            message.setText(mainText);
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
