package com.cg.jpacrud.client;


import java.util.Scanner;


import com.cg.jpacrud.entities.Customer;
import com.cg.jpacrud.service.StudentService;
import com.cg.jpacrud.service.StudentServiceImpl;

public class Client {

	static StudentService service = new StudentServiceImpl();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true)	//Continuous Loop
		{
		System.out.println("Choose the options");
		System.out.println("1.Add");
		System.out.println("2.Find by Id");
		System.out.println("3.Find by location");
		System.out.println("4.Update by Id");
		System.out.println("5.Delete by Id");
		System.out.println("6.Exit");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:addDetails();
			break;
		case 2:findById();
			break;
		case 3:findByLocation();
			break;
		case 4:updateById();
			break;
		case 5:removeById();
			break;
		case 6:
			System.exit(0);
			break;
		}
		}
	}
	private static void removeById() {
		Customer customer = new Customer();
		service.removeName(customer);
		
	}
	private static void updateById() {
		Customer customer = new Customer();
		service.updateName(customer);
		
	}
	private static void findByLocation() {
		for(Customer customer:service.getCustomerByLocation("Mumbai")) {
		System.out.println(customer);
	}
		
	}
	private static void findById() {
		Customer customer = new Customer();
		customer = service.findCustomerById(101);
		System.out.print("ID:"+customer.getCustomerId());
		System.out.println(" Name:"+customer.getCustomerName());
		System.out.println("Location:"+customer.getCustomerLocation());
		
	}
	private static void addDetails() {
		Customer customer = new Customer();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id:");
		int id=sc.nextInt();
		customer.setCustomerId(id);
		
		System.out.println("Enter name:");
		String name=sc.next();
		customer.setCustomerName(name);
		
		System.out.println("Enter location:");
		String loc=sc.next();
		customer.setCustomerLocation(loc);
		
		System.out.println("Enter email:");
		String mail=sc.next();
		customer.setCustomerEmail(mail);
		
		System.out.println("Enter dob:");
		String dob=sc.next();
		customer.setCustomerDob(dob);
		
		service.addCustomer(customer);
		System.out.println("Added");
		
	}
}
	//at this breakpoint,details from user

	/*customer.setCustomerId(106);
	customer.setCustomerName("Prachi");
	customer.setCustomerLocation("Mumbai");
	customer.setCustomerEmail("pra24@gmail.com");
	//student.setCustomerDob(new Date());
	customer.setCustomerDob("8-Dec-95");
	service.addCustomer(customer);
	System.out.println("One record added");*/
		
		/*//at this breakpoint, we have added one record to table
		student = service.findStudentById(100);
		System.out.print("ID:"+student.getStudentId());
		System.out.println(" Name:"+student.getName());
		
		student.setName("Sachin Tendulkar");
		service.updateStudent(student);
		
		//at this breakpoint, we have updated record added in first section
		student = service.findStudentById(100);
		System.out.print("ID:"+student.getStudentId());
		System.out.println(" Name:"+student.getName());
		
		//at this breakpoint, record is removed from table
		service.removeStudent(student);
		System.out.println("End of program...");*/
