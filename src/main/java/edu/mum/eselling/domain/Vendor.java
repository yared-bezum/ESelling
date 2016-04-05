package edu.mum.eselling.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendor extends User implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> products;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private BusinessContact businessContact;

	private boolean status;

	public Vendor() {
		super();
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public BusinessContact getBusinessContact() {
		return businessContact;
	}

	public void setBusinessContact(BusinessContact businessContact) {
		this.businessContact = businessContact;
	}

	public List<Product> getProducts() {
		return products;
		
	}

	public void addProducts(Product product) {
		products.add(product);
	}
	
	

}
