package edu.mum.eselling.controller;
import java.security.Principal;
import java.util.List;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.eselling.domain.Product;
import edu.mum.eselling.domain.Vendor;
import edu.mum.eselling.service.AdminService;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;
import edu.mum.eselling.smtp.EmailSettings;
import edu.mum.eselling.smtp.EmailUtil;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private AdminService adminService;
	@RequestMapping(value = "/pendingProducts", method = RequestMethod.GET)
	public String pendingProducts(Product product ,Model model){
		List<Product> p=productService.findPendingProducts();
		model.addAttribute("product",p);
		if(p.isEmpty()){
			model.addAttribute("noproduct","empty");
		}
		return "pendingProducts";
	}
		
	@RequestMapping(value = "/approveProducts")
    public String approveProduct(@ModelAttribute Product product ,@RequestParam("id") String id ,Model model,Principal principal) {
	
		Product newproduct=productService.find(Long.parseLong(id));
        newproduct.setApproval("approved");
            	
	    productService.save(newproduct);
	//send email
	    final String fromEmail = "pmesellingroup3@gmail.com"; //requires valid gmail id
        final String password = "lachimachidoo"; // correct password for gmail id
	//final String toEmail = newproduct.getVendor().getEmail();
	
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
      //  Vendor vendor= vendorService.getVendorByProductId(Long.parseLong(id));
				Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
	//	EmailUtil.sendEmail(session, toEmail, " Notification " + newproduct.getVendor().getFirstName(), newproduct.getVendor().getFirstName()+"Your Products you Posted on E-selling have been Approved. ");
	
	return "redirect:/pendingProducts";
}

	@RequestMapping(value = "/disapproveProduct")
    public String editItem(@ModelAttribute Product product ,@RequestParam("id") String id ,Model model) {
	
		Product newproduct=productService.find(Long.parseLong(id));
		newproduct.setApproval("disapproved");
				    productService.save(newproduct);
	    	    final String fromEmail = "pmesellingroup3@gmail.com"; //requires valid gmail id
        final String password = "lachimachidoo"; // correct password for gmail id
	//	final String toEmail = newproduct.getVendor().getEmail();
	
        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
        //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
		//Vendor vendor= vendorService.getVendorByProductId(Long.parseLong(id));
        
		Session session = Session.getInstance(EmailSettings.getEmailProperties(), auth);
		EmailUtil.sendEmail(session, "yared.bezum@gmail.com", " Notification " + newproduct.getVendor().getFirstName(), newproduct.getVendor().getFirstName()+"Your Products you Posted on E-selling have been DisApproved. ");
	
	return "redirect:/pendingProducts";
	
	}
		
	
	@ModelAttribute
	public void init(Model model,Principal principal){
		model.addAttribute("products",productService.findPendingProducts());
	    model.addAttribute("categories", categoryService.findAll());
	   
	  //  String name = principal.getName();
	    model.addAttribute("admin",adminService.getAdminByUserName(principal.getName()));
	}
	
}