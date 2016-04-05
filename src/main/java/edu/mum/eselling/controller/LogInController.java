package edu.mum.eselling.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.eselling.service.AdminService;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CredentialsService;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;

@Controller
public class LogInController {

	@Autowired
	CustomerService customerService;

	@Autowired
	VendorService vendorService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CredentialsService credentialService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session, SessionStatus status) {

		SecurityContextHolder.getContext().setAuthentication(null);
		status.setComplete();
		session.invalidate();
		return "redirect:/welcome";

	}

	@RequestMapping("/loginSuccess")
	public String defaultAfterLogin(HttpServletRequest request, Model model,
			Principal principal, HttpSession session) {

		session.setAttribute("name", principal.getName());
		String name = principal.getName();

		if (request.isUserInRole("ROLE_VENDOR")) {
               
			model.addAttribute("vendor",
					vendorService.getVendorByUserName(name));
			model.addAttribute("vendorProducts", productService
					.getAllProductsByVendorId(vendorService
							.getVendorByUserName(name).getId()));

			return "VendorPage";
		} else if (request.isUserInRole("ROLE_ADMIN")) {

			model.addAttribute("admin", adminService.getAdminByUserName(name));
			return "AdminPage";
		} else {

			model.addAttribute("customer",
					customerService.getCustomerByUserName(name));

			return "CustomerPage";
		}
	}

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("products", productService.findApprovedProducts());
	}

}
