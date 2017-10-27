package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.model.CustomerBean;



public interface ICustomerService {
	
	public abstract void add(CustomerBean bean);

	public abstract List<CustomerBean> getAllItems();
	
	

	public abstract CustomerBean getById(int customerId);
	
	public List<CustomerBean> retrieveCustomerId();

}
