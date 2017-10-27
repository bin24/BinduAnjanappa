package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;







import com.cg.dao.ICustomerDao;
import com.cg.model.CustomerBean;



@Service
@Transactional	//This annotation will make automatic transaction management 
public class CustomerServiceImpl implements ICustomerService {
	
	
	@Autowired
	private ICustomerDao dao;
	
	

	@Override
	public void add(CustomerBean bean) {
		
		 dao.add(bean);
		
	}



	@Override
	public List<CustomerBean> getAllItems() {
		
		return dao.getAllItems();
	}



	



	@Override
	public CustomerBean getById(int customerId) {
		return dao.getById(customerId);
		
	}



	@Override
	public List<CustomerBean> retrieveCustomerId() {
		return dao.retrieveCustomerId();
	}



	



	



	

}
