package com.cg.banking.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.banking.bean.UserBean;
import com.cg.banking.service.BankingServiceImpl;
import com.cg.banking.service.IBankingService;




public class BankingUi {
	static Scanner sc=new Scanner(System.in);
	static UserBean details=null;
	static UserBean details1=null;
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
			case 1:int userId=login();
							
							if(userId==0)
							{
								System.out.println("Login failed");
							}
							else
							{
								System.out.println("1.Change Password");
								System.out.println("2.Exit");
					
								System.out.println("Enter your choice");
								int choice1=sc.nextInt();
										switch(choice1)
											{
												case 1:changePassword(userId);
												break;
												
												
												case 2: System.exit(0);
												break;
				
				
											}
							}
			
			break;
			case 2:forgotPassword();
			break;
			case 3: System.exit(0);
			break;
			
			
			}
	
	  
	  
}
	  
  }




private static void changePassword(int userId) throws SQLException, IOException
{
	System.out.println("Enter new password:- ");
	String newPassword=sc.next();
	System.out.println("Re-Enter new password:- ");
	String reEnterNewPassword=sc.next();
	
	
	if(service.checkPassword(newPassword, reEnterNewPassword))
	{
		details=new UserBean(userId,newPassword);
		int res=service.updatePassword(details);
		if(res==0)
		{
			System.out.println("not updated");
		}
		else
		{
			System.out.println("OK Password updated");
			
		}
	}
	else
	{
		System.out.println("Password doesnot matched");
	}
	
}




private static int login() throws IOException, SQLException
	{
	
		System.out.println("Enter User Id:- ");
		String userIdString=sc.next();
		int userId=Integer.parseInt(userIdString);
		System.out.println("Enter password:- ");
		String loginPassword=sc.next();
		
		details=new UserBean(userId,loginPassword);
		
		boolean password=service.checkLogin(details);
		
		if(password==true)
		{
			if(loginPassword.equals("sbq500#"))
			{
				//ask user to update
				
				System.out.println("Enter new password:- ");
				String newPassword=sc.next();
				System.out.println("Re-Enter new password:- ");
				String reEnterNewPassword=sc.next();
				
				
				if(service.checkPassword(newPassword, reEnterNewPassword))
				{
					details=new UserBean(userId,newPassword);
					int res=service.updatePassword(details);
					if(res==0)
					{
						System.out.println("not updated");
					}
					else
					{
						System.out.println("OK Password updated");
						
					}
				}
				else
				{
					System.out.println("Password doesnot matched");
				}
				
				
				
			}
			else
			{
				//normal login
				System.out.println("OK user");
				
			}
			return userId;
		}
		else
		{
			System.out.println("Invalid");
		}
		
		return 0;
	
	}









private static void forgotPassword() throws IOException, SQLException
	{
	String securityAnswer=null;
	String securityQuestion=null;
	String sAnswer=null;
	
	ArrayList<UserBean> list=null;
	System.out.println("Enter User Id:- ");
	String userIdString=sc.next();
	int userId=Integer.parseInt(userIdString);
	
	details=new UserBean(userId);
	
	list=service.changePassword(details);
	
	
	
	
	
	for(UserBean m:list)
	{
		securityQuestion=m.getSecretQuestion();
		System.out.println("Security Question - "+securityQuestion);
		securityAnswer=m.getSecretQuestionAnswer();
		
		System.out.println("Enter Security Answer:- ");
		sAnswer=sc.next();
		
	}
	
	if(service.checkSecurityAnswer(securityQuestion,securityAnswer,sAnswer))
	{
		details=new UserBean(userId);
		int res=service.updatePassword(details);
		
		System.out.println("Hi-"+userIdString+"\n"+"Your new password is- sbq500# ");
	}
	else
	{
		System.out.println("Security answer not matched");
	}
	
	
	
	}




}


