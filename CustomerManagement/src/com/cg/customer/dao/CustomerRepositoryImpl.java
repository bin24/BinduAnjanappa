package com.cg.customer.dao;







import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.customer.dto.Customer;





@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Customer> getAll() {
				
			//TypedQuery<Customer> query = entityManager.createQuery("SELECT cust FROM Customer cust", Customer.class);
			Query q = entityManager.createNamedQuery("getAllCustomer");
			return q.getResultList();
			//return query.getResultList();
	}

	@Override
	public Customer addCustomerDetails(Customer cus) {
		if(cus!=null){
			entityManager.persist(cus);
		}	
		return cus;
	}

	@Override
	public Customer getCustById(int custId) {
		Customer e = new Customer();
		e = entityManager.find(Customer.class,custId);
		System.out.println("in Dao"+e);
		return e;
	}

	@Override
	public Customer updateCustomer(Customer cus) {
			if(cus!=null){
				cus = entityManager.merge(cus);
				System.out.println(cus);
				entityManager.flush();
			}
			return cus;
			
		}

	@Override
	public List<Integer> getAllCustomerId() {
		Query q = entityManager.createNamedQuery("getAllCustomerId");
		return q.getResultList();
	}
	
	}

