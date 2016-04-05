package edu.mum.eselling.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = -6212595579666071819L;
	@Id
	@GeneratedValue
	private long addressId;
	@NotEmpty(message = "{User.Street}")
	private String street;
	@NotEmpty(message = "{User.State}")
	private String state;
	@NotEmpty(message = "{User.ZipCode}")
	@Pattern(regexp = "^\\d{5}(-\\d{4})?$", message = "{Pattern.zipcode}")
	private String zipcode;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
