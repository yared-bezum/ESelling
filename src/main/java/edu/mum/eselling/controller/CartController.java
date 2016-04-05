package edu.mum.eselling.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.Product;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private Cart cart;
	@Autowired
	private ProductService productService;

	@Autowired
	CustomerService customerService;

	@RequestMapping("/cart/add/{productId}")
	public String addToCart(@PathVariable("productId") long productId,
			@RequestHeader("referer") String referer, Principal principal) {
		if (principal == null) {
			return "redirect:/login";
		}

		Product product = this.productService.getProductById(productId);
		this.cart.addProduct(product);

		product.setUnitsInStock(product.getUnitsInStock() - 1);
		product.setStatus("locked");

		productService.save(product);

		System.out.println("Product size: " + this.cart.getProducts().size());
		System.out.println(this.cart.getGrandTotal().toString());
		return "redirect:" + referer;
	}

	@RequestMapping("/cart/mycart")
	public String cart() {
		return "mycart";
	}

	@ModelAttribute
	public void init(Model model, HttpSession session, Principal principal) {

		if (principal != null) {
			session.setAttribute("cart", cart);
			model.addAttribute("customer",
					customerService.getCustomerByUserName(principal.getName()));
		}
	}
}
