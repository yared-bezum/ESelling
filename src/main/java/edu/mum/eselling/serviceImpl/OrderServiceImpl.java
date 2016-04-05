package edu.mum.eselling.serviceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Cart;
import edu.mum.eselling.domain.OrderDetail;
import edu.mum.eselling.domain.Product;
import edu.mum.eselling.domain.ProductOrder;
import edu.mum.eselling.repository.OrderRepository;
import edu.mum.eselling.service.CustomerService;
import edu.mum.eselling.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = false)
	public ProductOrder createOrder(Cart cart, Principal principal){
		ProductOrder productOrder = new ProductOrder();
		for(Entry<Product, Integer> line : cart.getProducts().entrySet()){
			productOrder.addOrderDetail(new OrderDetail(line.getKey(), line.getValue()));
		}
		productOrder.setOrderDate(new Date());
		productOrder.setCustomer(customerService.getCustomerByUserName(principal.getName()));
		return productOrder;
	}

	@Override
	public ProductOrder store(ProductOrder productOrder) {
		return orderRepository.save(productOrder);
	}



}
