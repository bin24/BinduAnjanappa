package com.cg.customer.dao;

import java.util.List;

import com.cg.customer.dto.Customer;

public interface CustomerRepository {

	List<Customer> getAll();

	Customer addCustomerDetails(Customer cus);

	Customer getCustById(int custId);

	Customer updateCustomer(Customer cus);

	List<Integer> getAllCustomerId();

	

}
