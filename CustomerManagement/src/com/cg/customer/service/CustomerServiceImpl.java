package com.cg.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customer.dao.CustomerRepository;
import com.cg.customer.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository custRepository;

	@Override
	public List<Customer> getAll() {
		return custRepository.getAll();
	}

	@Override
	public Customer addCustomerDetails(Customer cus) {
		return custRepository.addCustomerDetails(cus);
	}

	@Override
	public Customer getCustById(int custId) {
		return custRepository.getCustById(custId);
	}

	@Override
	public Customer updateCustomer(Customer cus) {
		return custRepository.updateCustomer(cus);
	}

	@Override
	public List<Integer> getAllCustomerId() {
		return custRepository.getAllCustomerId();
	}

	
	
}
