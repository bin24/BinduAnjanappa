package com.cg.banking.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.banking.bean.UserBean;
import com.cg.banking.service.BankingServiceImpl;
import com.cg.banking.service.IBankingService;



public class BankingUi {
	static Scanner sc=new Scanner(System.in);
	static UserBean details=null;
	static IBankingService service= new BankingServiceImpl();
	
	
  public static void main(String[] args) throws IOException, SQLException {
	  
	  
	  while(true)
		{
			System.out.println("1.Login");
			System.out.println("2.Forgot Password");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:login();
			break;
			case 2:forgotPassword();
			break;
			case 3: System.exit(0);
			break;
			
			}
	
	  
	  
}
	  
  }




private static void login() throws IOException, SQLException
	{
	
		System.out.println("Enter User Id:- ");
		String userIdString=sc.next();
		int userId=Integer.parseInt(userIdString);
		System.out.println("Enter password:- ");
		String loginPassword=sc.next();
		
		details=new UserBean(userId,loginPassword);
		
		boolean res=service.checkLogin(details);
		
		if(res==true)
		{
			System.out.println("OK user");
		}
		else
		{
			System.out.println("Invalid");
		}
		
		
	
	}
private static void forgotPassword()
	{
	
	
	}

}


