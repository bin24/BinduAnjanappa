package com.cg.jpacrud.dao;

import java.util.List;

import com.cg.jpacrud.entities.Customer;



public interface StudentDao {
	
	public abstract void commitTransaction();

	public abstract void beginTransaction();

	public abstract void addCustomer(Customer customer);

	public abstract Customer findCustomerById(int i);

	public abstract List<Customer> getCustomerByLocation(String string);

	public abstract void updateName(Customer customer);

	public abstract void removeName(Customer customer);
	
}

/*public abstract Student getStudentById(int id);

public abstract void addStudent(Student student);

public abstract void removeStudent(Student student);

public abstract void updateStudent(Student student);*/