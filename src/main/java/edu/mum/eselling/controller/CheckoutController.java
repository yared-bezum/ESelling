package edu.mum.eselling.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.MyFinance;
import edu.mum.eselling.domain.ProductOrder;
import edu.mum.eselling.domain.Transaction;
import edu.mum.eselling.service.CategoryService;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.MyFinanceService;
import edu.mum.eselling.service.OrderService;

@Controller
@SessionAttributes(types = { ProductOrder.class })
@RequestMapping("/cart/checkout")
public class CheckoutController {
	@Autowired
	private Cart cart;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MyFinanceService myFinanceService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public void show(Model model, Principal principal, HttpSession session) {
		if (principal == null) {
			System.out.println("Session not set");
		} else {

			System.out.println("Session set");
		}

		ProductOrder productOrder = this.orderService.createOrder(this.cart,
				principal);
		model.addAttribute("productOrder", productOrder);

	}

	@RequestMapping(method = RequestMethod.POST, params = "update")
	public String update(@ModelAttribute ProductOrder productOrder) {
		productOrder.updateOrderDetails();
		return "cart/checkout";
	}

	@RequestMapping(method = RequestMethod.POST, params = "order")
	public String checkout(SessionStatus status,
			@Validated @ModelAttribute ProductOrder productOrder,
			BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "cart/checkout";
		}

		MyFinance myFinance = myFinanceService
				.findMyFinanceByCreditCardNo(productOrder.getCustomer()
						.getCreditCard().getCreditCardNo().toString());
		if (myFinance.purchase(productOrder.getOrderPrice())) {
			myFinance.setCreditAvailable(myFinance.getCreditAvailable()
					.subtract(productOrder.getOrderPrice()));
			myFinance.setCreditUsed(myFinance.getCreditUsed().add(
					productOrder.getOrderPrice()));

			this.orderService.store(productOrder);
			status.setComplete(); // remove order from session
			this.cart.clear(); // clear the cart
			return "redirect:/loginSuccess";

		} else {
			model.addAttribute("cannotPurchase", "true");
			return "cart/checkout";
		}

	}

	@RequestMapping(method = RequestMethod.POST, params = "cancel")
	public String cancel(SessionStatus status,
			@ModelAttribute ProductOrder productOrder, HttpSession session) {
		status.setComplete(); // remove order from session
		this.cart.clear(); // clear the cart
		return "redirect:/loginSuccess";
	}

	@ModelAttribute
	public void init(Model model, Principal principal) {
		//
		model.addAttribute("customer",
				customerService.getCustomerByUserName(principal.getName()));
		model.addAttribute("categories", categoryService.findAll());
	}
}
