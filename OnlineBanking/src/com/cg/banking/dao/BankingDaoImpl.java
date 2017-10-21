package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;
import com.cg.banking.dbutil.DbUtil;

public class BankingDaoImpl implements IBankingDao {
      Connection conn;
      int rows=0;
	private int result;
	private int flag = 0;
	
 
	@Override
	public int requestforcheckbook(UserBean u) throws SQLException, IOException {
		    
		conn=DbUtil.getConnection();
		 String result = null;
	    // int acc_id;
		 String sql1 = "select account_id from usertable";
		 PreparedStatement ps2 = conn.prepareStatement(sql1);
		 ResultSet rs = ps2.executeQuery();
		 
		 while(rs.next())
    	 {
			 
			 int acc_id = rs.getInt(1);
			 
				

			 if(acc_id != (u.getAccountNo()))
			 {
				 flag  = 0;
				
				
			 }
			 else
			 {
				 flag = 1;
			 }
			 
		
    		
    	 }
		
		 return  flag;
	
	}


	@Override
	public int addDetails(UserBean u)  {
		String insertquery= "Insert into Service_Tracker values(chk_book.nextval,?,?,sysdate,'Open') ";
		
		PreparedStatement ps;
		try {
			
			conn=DbUtil.getConnection();
			ps = conn.prepareStatement(insertquery);
			ps.setString(1,u.getService_Desc());
			ps.setInt(2,u.getAccountNo());
		    
			rows = ps.executeUpdate();
			
			System.out.println("in addDetails"+rows);
			
			if(rows==1)
			{
			String sql = "Select chk_book.currval from dual ";
			 PreparedStatement ps1 = conn.prepareStatement(sql);
			 ResultSet rs = ps1.executeQuery();
			 while(rs.next())
	    	 {
				 result = rs.getInt(1);
	    		 System.out.println(result);
	    	 }
			
			
			
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
   
		
		 }
	
	
		return result;
	

	}
}
