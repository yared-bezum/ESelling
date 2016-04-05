package edu.mum.eselling.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.eselling.domain.Customer;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.VendorService;
import edu.mum.eselling.smtp.EmailSettings;
import edu.mum.eselling.smtp.EmailUtil;
@Aspect
@Component
public class EmailAdvise {
	@Autowired
	CustomerService CustomerService;
	@Autowired
	VendorService vendorService;
//	@After("execution(* edu.mum.eselling.controller.SignupController.processVendorSignUp(..))&& args(vendor)")
//	public void emailaftervendor(JoinPoint joinpoint,Vendor vendor) {
//		
//		final String fromEmail = "hyaea2015@gmail.com"; //requires valid gmail id
//        final String password = "test@1234"; // correct password for gmail id
//		final String toEmail = vendor.getEmail();
//		
//        //create Authenticator object to pass in Session.getInstance argument
//        Authenticator auth = new Authenticator() {
//        //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
//		
//		Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
//		EmailUtil.sendEmail(session, toEmail, " Welcome " + vendor.getFirstName(),    vendor.getFirstName() + "you have successfully signedup to E-Selling. You can now sign in and Post your Products in  our site. ");
//		}
	@After("execution(* edu.mum.eselling.controller.SignupController.processCustomerSignUp(..))")
	public void emailaftercustmor(JoinPoint joinpoint ) {

		final String fromEmail = "mhyaea2015@gmail.com"; //requires valid gmail id
        final String password = "test@1234"; // correct password for gmail id
		final String toEmail = "yared.bezum@gmail.com";
		
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
		
		Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
		EmailUtil.sendEmail(session, toEmail, " Welcome " + "Peter",  "Andrew" + "you have successfully signedup to E-Selling. You can now sign in and Post your Products in  our site. ");
		}
}
