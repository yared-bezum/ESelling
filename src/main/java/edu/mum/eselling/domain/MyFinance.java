package edu.mum.eselling.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class MyFinance implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;

	@Id
	@GeneratedValue
	private long Id;

	@NotNull(message = "{NotEmpty.CreditCard.number.validation}")
	@Pattern(regexp = "[2-9][0-9]{15}", message = "{Pattern.CreditCard.number.validation}")
	private String creditCardNo;

	private String creditCardType;
	@NotNull(message = "{NotEmpty.CreditCard.expireMonth.validation}")
	private Integer expMonth;
	@NotNull(message = "{NotEmpty.CreditCard.expireYear.validation}")
	private Integer expYear;
	@NotNull(message = "{NotEmpty.CreditCard.cvv.validation}")
	@Range(min = 100, max = 999)
	private Integer securityCode;

	@NotEmpty(message = "{NotEmpty.CreditCard.name.validation}")
	private String nameOnCard;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CreditCard creditCard;
	private BigDecimal creditLimit;
	private BigDecimal creditAvailable;
	private BigDecimal creditUsed;

	public MyFinance() {
		super();
		creditLimit = new BigDecimal(50_000);
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public Integer getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(Integer expMonth) {
		this.expMonth = expMonth;
	}

	public Integer getExpYear() {
		return expYear;
	}

	public void setExpYear(Integer expYear) {
		this.expYear = expYear;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

	public MyFinance(CreditCard creditCard) {
		this.creditCard = creditCard;
		creditLimit = new BigDecimal(50_000);
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public BigDecimal getCreditAvailable() {
		return creditAvailable;
	}

	public void setCreditAvailable(BigDecimal creditAvailable) {
		this.creditAvailable = creditAvailable;
	}

	public BigDecimal getCreditUsed() {
		return creditUsed;
	}

	public void setCreditUsed(BigDecimal creditUsed) {
		this.creditUsed = creditUsed;
	}

	public Boolean purchase(BigDecimal amount) {
		if (this.creditAvailable.compareTo(amount) >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
