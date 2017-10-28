package com.cg.jpacrud.service;

import java.util.List;

import com.cg.jpacrud.entities.Customer;


public interface StudentService {

	public abstract void addCustomer(Customer customer);

	public abstract Customer findCustomerById(int i);

	public abstract List<Customer> getCustomerByLocation(String location);

	public abstract void updateName(Customer customer);

	public abstract void removeName(Customer customer);

}

/*public abstract void addStudent(Student student);

public abstract void updateStudent(Student student);

public abstract void removeStudent(Student student);

public abstract Student findStudentById(int id);*/