package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.cg.banking.bean.UserBean;
import com.cg.banking.dbUtil.DbUtil;



public class BankingDaoImpl implements IBankingDao {
	
	Connection conn=null;
	int loginId1=0;
	String password=null;
	

	


	@Override
	public boolean checkLogin(UserBean bean) throws IOException, SQLException 
	{

		conn=DbUtil.getConnection();
		
		
		
		
		String sql="Select * from user_details where user_id=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setInt(1,bean.getUserId());
		
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			
			 loginId1=rs.getInt(2);
			 
			 password=rs.getString(3);
			
		}
		
		if(bean.getUserId()==loginId1 && bean.getLoginPassword().equals(password))
		{
			System.out.println("true");
			return true;
		}
		else
		{
			System.out.println("false");
			return false;
		}
		
		
	}
	
	

}
