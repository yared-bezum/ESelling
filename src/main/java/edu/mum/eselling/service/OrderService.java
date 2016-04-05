package edu.mum.eselling.service;

import java.security.Principal;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.ProductOrder;

public interface OrderService {

	public ProductOrder createOrder(Cart cart, Principal principal);

	public ProductOrder store(ProductOrder productOrder);
}
