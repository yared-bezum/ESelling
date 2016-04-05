package edu.mum.eselling.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class BusinessContact implements Serializable {

	private static final long serialVersionUID = -3794885616176050983L;
	
	@Id
	@GeneratedValue
	private Long businessContactId;
	
	private String businessName;
	private String contactPersonName;
	private String businessPhoneNo;


	
	public BusinessContact() {
		super();
	}


	public Long getBusinessId() {
		return businessContactId;
	}

	public void setBusinessId(Long businessContactId) {
		this.businessContactId = businessContactId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getBusinessPhoneNo() {
		return businessPhoneNo;
	}

	public void setBusinessPhoneNo(String businessPhoneNo) {
		this.businessPhoneNo = businessPhoneNo;
	}
	
	

}
