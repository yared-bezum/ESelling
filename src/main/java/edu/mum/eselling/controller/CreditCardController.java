package edu.mum.eselling.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.eselling.domain.CreditCard;

@Controller
public class CreditCardController {

	@RequestMapping(value = "/creditcard", method = RequestMethod.GET)
	public String creditCard(Model model) {
		CreditCard creditCard = new CreditCard();
		model.addAttribute("creditCard", creditCard);
		return "creditCard";
	}

	@ModelAttribute
	public void init(Model model) {
		List<String> months = new LinkedList<String>();
		months.add("01");
		months.add("02");
		months.add("03");
		months.add("03");
		months.add("04");
		months.add("05");
		months.add("06");
		months.add("07");
		months.add("08");
		months.add("09");
		months.add("10");
		months.add("11");
		months.add("12");
		model.addAttribute("months", months);
	}
}
