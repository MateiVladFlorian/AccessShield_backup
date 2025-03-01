package core;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author vlad
 */
public class EmailProvider {
    public static void Send(String sender, String password, String receiver, String subject, String body) {
        String[] server = new String[] { "gmail", "outlook", "yahoo" };
        String[] smtp_server = new String[] { "smtp.gmail.com", "smtp-mail.outlook.com", "smtp.mail.yahoo.com" };  
        String[] port = new String[] { "587", "587", "465" };
        
        int index = -1;
        
        /* find the right e-mail provider */
        for(int i = 0; i < server.length; i++) {
            if(sender.contains(server[i])) {
                index = i; break;
            }
        }
        
        if(index < 0) { // returned -1
        } else {
            Properties props = new Properties();
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host", smtp_server[index]);
            props.put("mail.smtp.port", port[index]);
            
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender, password);
                    }
            });
            
           try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sender));
                
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
                message.setSubject(subject);
                
                message.setText(body);
                Transport.send(message);
                //return 1;
            }catch(MessagingException ex) {
                System.out.println("" + ex.getMessage());
                //return 0;
            }
        }
    }
}
