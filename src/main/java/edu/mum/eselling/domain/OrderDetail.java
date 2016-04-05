package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 9029113477551790189L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(optional = false)
	private Product product;

	private int quantity = 1;

	public OrderDetail() {
		super();
	}

	public OrderDetail(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		if (this.product != null) {
			return this.product.getUnitPrice().multiply(
					new BigDecimal(this.quantity));
		}
		return BigDecimal.ZERO;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		OrderDetail other = (OrderDetail) object;

		return (this.id == other.id);
	}

	@Override
	public int hashCode() {
		return new org.apache.commons.lang.builder.HashCodeBuilder().append(
				this.id).toHashCode();
	}

}
