package com.cg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;





import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customer_spring")
@NamedQueries({
			@NamedQuery(name = "getAllItems", query = "select detail from CustomerBean detail"),
			@NamedQuery(name = "getById", query = "select detail from CustomerBean detail WHERE detail.customerId=:pCustId"),
			@NamedQuery(name = "getAllId", query = "select detail.customerId from CustomerBean detail")
			
		})
public class CustomerBean {
	

	@Id
	@Column(name="cust_id")
	@Min(value=0,message="Can not be negative")
	@NotNull
	private int customerId;
	
	
	@Column(name="customer_name")
	@NotEmpty(message="required")
	@Size(min=3,max=4,message="Enter the valid size")
	@Pattern(regexp="[A-Z].*",message="Should start with capital letter")
	private String customerName;
	
	
	
	
	@Column(name="mobile")
	@Pattern(regexp="[0-9]{10}",message="Should be exactly ten digit")
	private String customerMobile;
	
	
	
	@Column(name="email")
	@Email(message="Enter the valid email")
	@NotEmpty(message="Enter valid email")
	private String customerEmail;
	
	
	
	@Column(name="dob")
	@NotNull(message="Fill Dob")
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@Past(message="Please enter valid dob") 
	private Date customerDob;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Date getCustomerDob() {
		return customerDob;
	}
	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}
	
	

}
