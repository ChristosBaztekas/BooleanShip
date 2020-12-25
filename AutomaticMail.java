import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AutomaticMail {
    public static void sendMail(String usersMail) throws MessagingException {
        System.out.println("Preparing to send mail");
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
        Message message = prepareMessage(session,mail,usersMail);
        Transport.send(message);
        System.out.println("Message sent successfully!");
    }

    private static Message prepareMessage(Session session, String mail,String usersMail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(usersMail));
            message.setSubject("First Automatic mail");
            message.setText("This mail is sent using the mail api");
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
