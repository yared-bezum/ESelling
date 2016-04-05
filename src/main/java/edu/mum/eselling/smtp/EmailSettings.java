package edu.mum.eselling.smtp;
import java.util.Properties;



public class EmailSettings {
	
	public static Properties getEmailProperties(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        return props;
			}
//	public static Authenticator getEmailAuthentication(){
//        final String fromEmail = "pmesellingroup3@gmail.com"; //requires valid gmail id
//        final String password = "lachimachidoo"; // correct password for gmail id
// 		
//        //create Authenticator object to pass in Session.getInstance argument
//        Authenticator auth = new Authenticator() {
//        //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
//        return auth;
//		
//	}

}
