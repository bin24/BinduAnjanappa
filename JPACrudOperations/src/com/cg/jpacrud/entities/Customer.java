package com.cg.jpacrud.entities;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="customer_id")
	private int customerId;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="customer_location")
	private String customerLocation;
	@Column(name="customer_email")
	private String customerEmail;
	@Column(name="customer_dob")
	private String customerDob;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerLocation() {
		return customerLocation;
	}
	public void setCustomerLocation(String customerLocation) {
		this.customerLocation = customerLocation;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(String string) {
		this.customerDob = string;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", customerLocation=" + customerLocation
				+ ", customerEmail=" + customerEmail + ", customerDob="
				+ customerDob + "]";
	}
	
	
}
