package edu.mum.eselling.controller;

import java.util.Arrays;
import java.util.List;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.eselling.domain.Credentials;
import edu.mum.eselling.domain.Customer;
import edu.mum.eselling.domain.MyFinance;
import edu.mum.eselling.domain.Vendor;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CredentialsService;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.MyFinanceService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;
import edu.mum.eselling.smtp.EmailSettings;
import edu.mum.eselling.smtp.EmailUtil;

@Controller
public class SignupController {

	@Autowired
	CustomerService CustomerService;

	@Autowired
	VendorService vendorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CredentialsService credentialService;

	@Autowired
	private MyFinanceService myFinanceService;

	@RequestMapping(value = "/CustomerSignUp", method = RequestMethod.GET)
	public String customerSignup(@ModelAttribute Customer customer) {

		return "CustomerSignUp";
	}

	
	//customer signup
	
	@RequestMapping(value = "/CustomerSignUp", method = RequestMethod.POST)
	public String processCustomerSignUp(
			@Valid @ModelAttribute Customer customer, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) 
	
	{
		
		customer.getCreditCard().getNameOnCard().toLowerCase();
		if (result.hasErrors()) {
			return "CustomerSignUp";
		}

		List<Credentials> userName = credentialService.getAll();
		customer.getCredentials().getUsername().toLowerCase();
		for (Credentials c : userName) {
			if (c.getUsername().equals(customer.getCredentials().getUsername())) {
				model.addAttribute("username", "True");
				return "CustomerSignUp";
			}
		}
		if(!(customer.getCredentials().getPassword().equals(customer.getCredentials().getVerifyPassword()))){
			model.addAttribute("password","true");
			return "CustomerSignUp";
		}
		
		
		//Credit card Information check
		List<MyFinance> finance = myFinanceService.getAll();
		
		int found=0;
		for (MyFinance f : finance) {
			if(f.getCreditCardNo().equals(customer.getCreditCard().getCreditCardNo())){
				found=1;
			}
		}
					
					/*if(f.getCreditCardType() != customer
							.getCreditCard().getCreditCardType()
					|| f.getExpMonth() != customer
							.getCreditCard().getExpMonth()
					|| f.getExpYear() != customer
							.getCreditCard().getExpYear()
					|| f.getSecurityCode() != customer
							.getCreditCard().getSecurityCode()
					|| f.getNameOnCard()
							.equals(customer.getCreditCard().getNameOnCard())) 

				model.addAttribute("wrongCreditCard", "True");
				return "CustomerSignUp";

			}
			else{*/
		if(found==0){
					model.addAttribute("nonexistent","true");
					return "CustomerSignUp";
				}
			

		
		
		customer.getCredentials().setPassword(
				getHashPassword(customer.getCredentials().getPassword()));
		customer.setPassword(getHashPassword(customer.getCredentials()
				.getPassword()));

		

		CustomerService.addNewCustomer(customer);
		redirectAttributes.addFlashAttribute("successful", "true");

		//send email 
		final String fromEmail = "hyaea2015@gmail.com"; //requires valid gmail id
        final String password = "test@1234"; // correct password for gmail id
		final String toEmail = customer.getEmail();

		
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
		
		Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
		EmailUtil.sendEmail(session, toEmail, " Welcome " + customer.getFirstName(), customer.getFirstName()+"you have successfully signedup to E-Selling. You can now sign in and purchase from our site. ");
	return "redirect:/welcome";
	}

	//Vendor Signup
	
	
	@RequestMapping(value = "/VendorSignUp", method = RequestMethod.GET)
	public String vendorSignup(@ModelAttribute Vendor vendor) {

		return "VendorSignUp";
	}

	@RequestMapping(value = "/VendorSignUp", method = RequestMethod.POST)
	public String processVendorSignUp(@Valid @ModelAttribute Vendor vendor,
			BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		
		vendor.getCreditCard().getNameOnCard().toLowerCase();
		if (result.hasErrors()) {
			return "VendorSignUp";
		}
		vendor.getCredentials().getUsername().toLowerCase();

		List<Credentials> userName = credentialService.getAll();

		for (Credentials c : userName) {
			if (c.getUsername().equals(vendor.getCredentials().getUsername())) {
				model.addAttribute("username", "True");
				return "VendorSignUp";
			}
		}
		if(!(vendor.getCredentials().getPassword().equals(vendor.getCredentials().getVerifyPassword()))){
			model.addAttribute("password","true");
			return "VendorSignUp";
		}
		
		
		//Credit card Information check
		List<MyFinance> finance = myFinanceService.getAll();
     int found= 0;
		for (MyFinance f : finance) {
		 if(f.getCreditCardNo().equals(vendor.getCreditCard().getCreditCardNo())){
			 found =1;
		 }
		}
			
				/*if(!f.getCreditCardType().equals(vendor
							.getCreditCard().getCreditCardType())
			
					|| f.getExpYear() != vendor
							.getCreditCard().getExpYear()
					|| f.getSecurityCode() != vendor
							.getCreditCard().getSecurityCode()
					|| (!f.getNameOnCard()
							.equals(vendor.getCreditCard().getNameOnCard())) )

					model.addAttribute("wrongCreditCard", "True");
				
				return "VendorSignUp";
			}
				else{*/
		if(found==0){
					model.addAttribute("nonexistent","true");
					return "VendorSignUp";
				}
		 
	

		vendor.getCredentials().setPassword(
				getHashPassword(vendor.getCredentials().getPassword()));
		vendor.setPassword(getHashPassword(vendor.getCredentials()
				.getPassword()));

		redirectAttributes.addFlashAttribute("successful", "true");
		vendorService.addNewVendor(vendor);

		final String fromEmail = "hyaea2015@gmail.com"; //requires valid gmail id
        final String password = "test@1234"; // correct password for gmail id
		final String toEmail = vendor.getEmail();

		
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
		
		Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
		EmailUtil.sendEmail(session, toEmail, " Welcome " + vendor.getFirstName(),    vendor.getFirstName() + "you have successfully signedup to E-Selling. You can now sign in and Post your Products in  our site. ");
		
		
		return "redirect:/welcome";
	}

	@ModelAttribute
	public void init(Model model) {

		Integer[] months = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
				12 };
		Integer[] years = new Integer[] { 2015, 2016, 2017, 2018, 2019, 2020,
				2021 };
		String[] states = new String[] { "OH", "VA", "OK", "OR", "SC", "NY",
				"IA", "MD", "NH", "NV", "LA", "FL", "TX", "UT" };
		String[] creditType = new String[] { "VISA", "MASTER" };
		Arrays.asList(months);
		Arrays.asList(years);
		Arrays.asList(states);
		Arrays.asList(creditType);
		model.addAttribute("months", months);
		model.addAttribute("years", years);
		model.addAttribute("states", states);
		model.addAttribute("creditType", creditType);
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("products", productService.findApprovedProducts());

	}

	public String getHashPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}

}
