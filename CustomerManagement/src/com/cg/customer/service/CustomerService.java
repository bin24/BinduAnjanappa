package com.cg.customer.service;

import java.util.List;

import com.cg.customer.dto.Customer;

public interface CustomerService {

	List<Customer> getAll();

	Customer addCustomerDetails(Customer cus);

	Customer getCustById(int custId);

	Customer updateCustomer(Customer cus);

	List<Integer> getAllCustomerId();
	
}
