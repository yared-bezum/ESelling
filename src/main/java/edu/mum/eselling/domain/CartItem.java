package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;



public class CartItem implements Serializable {

	private static final long serialVersionUID = -6212595579666071819L;

	private int quantity;
	private Product product;
	private BigDecimal totalPrice;
	
	public CartItem() {
		super();
	}
	public CartItem(Product product){
		this.quantity=1;
		this.product=product;
		this.totalPrice=product.getUnitPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}
