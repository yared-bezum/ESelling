package edu.mum.eselling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/", "/welcome" })
	public String welcome(Model model) {

		return "welcome";
	}

	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("products", productService.findApprovedProducts());
		model.addAttribute("categories", categoryService.findAll());
	}

}
