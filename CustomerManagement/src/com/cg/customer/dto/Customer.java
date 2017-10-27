package com.cg.customer.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
	@NamedQuery(name = "getAllCustomerId", query = "SELECT cust.custId FROM Customer cust")
})
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cust_id")
	private int custId;
	
	@NotEmpty(message="Customer Name is Required")
	@Size(min = 4,message="Name should have atleast 4 character")
	private String name;
	
	@NotNull(message="quantity Required")
	private int quantity;
	
	private String country;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer()
	{
		
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", quantity="
				+ quantity + ", country=" + country + "]";
	}

	

	
	
	

}
