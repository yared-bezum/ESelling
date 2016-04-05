package edu.mum.eselling.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long transactionId;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CreditCard> creditCards;
	@Temporal(TemporalType.DATE)
	private Date transactionDate;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ProductOrder order;

	public Transaction() {
		super();
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public List<CreditCard> getCreditCard() {
		return creditCards;
	}

	public void addCreditCard(CreditCard creditCard) {
		creditCards.add(creditCard);
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public ProductOrder getOrders() {
		return order;
	}

	public void setOrders(ProductOrder order) {
		this.order = order;
	}

	
}
