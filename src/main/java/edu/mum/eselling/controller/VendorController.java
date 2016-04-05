package edu.mum.eselling.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.eselling.domain.Product;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;
import edu.mum.eselling.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	ProductService productService;

	@Autowired
	VendorService vendorService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/myProducts", method = RequestMethod.GET)
	public String getItemById(Model model, Principal principal) {
		String name = principal.getName();
		List<Product> myProducts = productService
				.getAllProductsByVendorId(vendorService.getVendorByUserName(
						name).getId());

		if (myProducts.isEmpty()) {
			// System.out.println("true");
			model.addAttribute("emptylist", "true");
		}

		model.addAttribute("vendorProducts", myProducts);

		return "myProducts";
	}

	@RequestMapping("/vendor")
	public String getVendorPage(Model model) {

		return "VendorPage";
	}

	@ModelAttribute
	public void init(Model model, Principal principal) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("vendor",
				vendorService.getVendorByUserName(principal.getName()));
	}
}
