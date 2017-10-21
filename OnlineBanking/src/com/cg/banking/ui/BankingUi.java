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
	static int totalAttemptlogin=0;
	static int idCheck=0;
	
	
	
  public static void main(String[] args) throws IOException, SQLException {
	  
	
	  //login home page
	  while(true)
		{
			System.out.println("1.Login");
			System.out.println("2.Forgot Password");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1: login();
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
	//accept to change password
	
	System.out.println("Enter new password:- ");
	String newPassword=sc.next();
	System.out.println("Re-Enter new password:- ");
	String reEnterNewPassword=sc.next();
	
	//matching password from service
	
	if(service.checkPassword(newPassword, reEnterNewPassword))
	{
		details=new UserBean(userId,newPassword);
		int res=service.updatePassword(details);
		
		//if res=0 then password not updated
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




private static void login() throws IOException, SQLException
	{
		//function to login
		
		System.out.println("Enter User Id:- ");
		String userIdString=sc.next();		
		int userId=Integer.parseInt(userIdString);
		
		System.out.println("Enter password:- ");
		String loginPassword=sc.next();
		
		//pass detail to bean
		details=new UserBean(userId,loginPassword);
		
		//check login detail in dao and get status
		
		boolean password=service.checkLogin(details);
		
		if(password==false)
		{
			
			System.out.println("invalid");
			
			
			//locking process for max attempt
			if(totalAttemptlogin>0)
			{
				//if other id then set attempt to 0
				if(idCheck!=userId)
				{
					totalAttemptlogin=0;
				}
			}
			// if same user id then increase value of attempt for particular id
			idCheck=userId;
			totalAttemptlogin++;
		}
		else
		{	
			totalAttemptlogin=0;
			
			// if login after reset through forgot password
			
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
				//get all of account Id for other function to use
				long accountId=0;
				ArrayList<UserBean> listAccountId=null;
				details=new UserBean(userId);
				listAccountId =service.getAccountId(details);
				
				for(UserBean m:listAccountId)
				{
					accountId=m.getAccountId();
					
					System.out.println("Account ids are:-"+accountId);
					
					
				}
				
				//normal login
				System.out.println("OK user");
				
					//display main login screen
					
					System.out.println("1.View Statement");
					System.out.println("2.Change Address/Mobile No");
					System.out.println("3.Request for ChequeBook");
					System.out.println("4.Track Service Request");
					System.out.println("5.Fund transfer");
					System.out.println("6.Change Password");
					System.out.println("7.Exit");
	
		
					System.out.println("Enter your choice");
					
					int choiceHome=sc.nextInt();
							switch(choiceHome)
								{
									/*case 1:viewStatement();
									break;
									
									case 2:changeAddressMobile();
									break;
									
									case 3:requestChequeBook(userId);
									break;
									
									case 4:trackServiceRequest();
									break;
									
									case 5:fundTransfer();
									break;*/
								
									case 6:changePassword(userId);
									break;
								
									case 7: System.exit(0);
									break;
										
	
								}
					
					
				
				
			}
			
			
		}
		//locking user for max attempt
		if(totalAttemptlogin==3)
		{
			details=new UserBean(userId);
			int res=service.updateLock(details);
			if(res>0)
			{
				System.out.println("Hi user-"+userId+". You have reached maximum attempt ");
			}
			
			
			
			
		}
		
		
	
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


