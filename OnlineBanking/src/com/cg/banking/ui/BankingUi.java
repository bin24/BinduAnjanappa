package com.cg.banking.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.banking.bean.UserBean;
import com.cg.banking.service.BankingServiceImpl;
import com.cg.banking.service.IBankingService;

public class BankingUi 
{
	static int res;
	static Scanner sc=new Scanner(System.in);
	static int rs;
	
	static IBankingService service1 = new BankingServiceImpl();
	
	static  UserBean u = new UserBean();
	
  public static void main(String[] args) throws SQLException, IOException 
  {
	
	  System.out.println("Banking Application");
	  
	  System.out.println("**********************");
	  
	  while(true)
	  {
		  System.out.println("Enter your request for Check book\n1.chequebook");
		  System.out.println("Enter your choice");
		  int choice = sc.nextInt();
		   switch (choice)
		   {
		   case 1:
			   requestforcheckbook();
			   break;
		   }
		  
		  
		  
		  
	  }
}


private static void requestforcheckbook() throws SQLException, IOException {
	// TODO Auto-generated method stub
	
	service1 = new BankingServiceImpl();
	
	System.out.println("Enter the service required"
			+ "\n1.checkbook");

	System.out.println("Enter your account id");
	int accountNo =sc.nextInt();
	
	u.setAccountNo(accountNo);
	u.setService_Desc("Checkbook");
	
	
	 res =service1.requestforcheckbook(u);

	 if(res == 1)
	 {
		 rs = service1.addDetails(u);
		 System.out.println("Request for Check book has been Approved. service   id :<"+rs+">");
		 
	 }
	 else
	 {
		 System.out.println("Sorry !!! AccountId"+u.getAccountNo()+"does not exist");

	 }
	
	 
	 
		
	
	
}
}
