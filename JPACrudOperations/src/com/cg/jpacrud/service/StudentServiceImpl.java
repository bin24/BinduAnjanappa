package com.cg.jpacrud.service;


import java.util.List;

import com.cg.jpacrud.dao.StudentDao;
import com.cg.jpacrud.dao.StudentDaoImpl;
import com.cg.jpacrud.entities.Customer;


public class StudentServiceImpl implements StudentService {

	private StudentDao dao;

	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public void addCustomer(Customer customer) {
		dao.beginTransaction();
		dao.addCustomer(customer);
		dao.commitTransaction();
		
	}

	@Override
	public Customer findCustomerById(int i) {
		dao.beginTransaction();
		Customer customer=dao.findCustomerById(i);
		return customer;
	}

	@Override
	public List<Customer> getCustomerByLocation(String location) {
		return dao.getCustomerByLocation(location);
	}

	@Override
	public void updateName(Customer customer) {
		dao.beginTransaction();
		dao.updateName(customer);
		dao.commitTransaction();
		
	}

	@Override
	public void removeName(Customer customer) {
		dao.beginTransaction();
		dao.removeName(customer);
		dao.commitTransaction();
		
	}

	
	

	/*@Override
	public void addStudent(Student student) {
		dao.beginTransaction();
		dao.addStudent(student);
		dao.commitTransaction();
	}
	
	@Override
	public void updateStudent(Student student) {
		dao.beginTransaction();
		dao.updateStudent(student);
		dao.commitTransaction();
	}
	
	@Override
	public void removeStudent(Student student) {
		dao.beginTransaction();
		dao.removeStudent(student);
		dao.commitTransaction();
	}
	
	@Override
	public Student findStudentById(int id) {
		//no need of transaction, as it's an read operation
		Student student  = dao.getStudentById(id);
		return student;
	}*/
}
