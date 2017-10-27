package com.cg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.model.CustomerBean;


@Repository
public class CustomerDaoImpl implements ICustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(CustomerBean bean) {
		
		
		entityManager.persist(bean);
		entityManager.flush();	//required to reflect changes on database
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerBean> getAllItems() {
		
		Query query = entityManager.createNamedQuery("getAllItems");
		return query.getResultList();
		
	}

	@Override
	public CustomerBean getById(int customerId) {
		//CustomerBean customer = entityManager.find(CustomerBean.class, customerId);
		
	//	TypedQuery<CustomerBean> query = entityManager.createNamedQuery("getById", CustomerBean.class).setParameter("pCustId", customerId);
		
		Query query = entityManager.createNamedQuery("getById", CustomerBean.class).setParameter("pCustId", customerId);
		
		return (CustomerBean) query.getSingleResult();
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerBean> retrieveCustomerId() {
		
		
		Query query = entityManager.createNamedQuery("getAllId");
		return (List<CustomerBean>) query.getResultList();
		
		
	}
	
	

}
