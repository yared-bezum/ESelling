package edu.mum.eselling.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ProductOrder> orders;

	public Customer() {
		super();
	}

	public List<ProductOrder> getOrders() {
		return orders;
	}

	public void addOrders(ProductOrder order) {
		orders.add(order);
	}

}
