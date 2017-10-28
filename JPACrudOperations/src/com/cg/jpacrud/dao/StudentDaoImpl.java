package com.cg.jpacrud.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.cg.jpacrud.entities.Customer;


public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	public StudentDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
		
	}
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	@Override
	public Customer findCustomerById(int i) {
		Customer customer=entityManager.find(Customer.class, i);
		return customer;
	}

	@Override
	public List<Customer> getCustomerByLocation(String location) {
		String qStr = "SELECT customer FROM Customer customer WHERE customer_location=:loc";
		TypedQuery<Customer> query = entityManager.createQuery(qStr, Customer.class);
		query.setParameter("loc", location);
		return query.getResultList(); 
	}

	@Override
	public void updateName(Customer customer) {
		Customer existingcustomer=entityManager.find(Customer.class, 106);
		existingcustomer.setCustomerName("Govind");
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void removeName(Customer customer) {
		Customer existingcustomer=entityManager.find(Customer.class, 103);
		entityManager.remove(existingcustomer);
		entityManager.getTransaction().commit();
		
	}

	
}


/*@Override
public Student getStudentById(int id) {
	Student student = entityManager.find(Student.class, id);
	return student;
}

@Override
public void addStudent(Student student) {
	entityManager.persist(student);
}

@Override
public void removeStudent(Student student) {
	entityManager.remove(student);
}

@Override
public void updateStudent(Student student) {
	entityManager.merge(student);
}*/

