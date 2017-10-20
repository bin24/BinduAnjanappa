package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;

import com.cg.banking.bean.UserBean;
import com.cg.banking.dbUtil.DbUtil;




public class BankingDaoImpl implements IBankingDao {
	
	Connection conn=null;
	
	

	


	@Override
	public boolean checkLogin(UserBean bean) throws IOException, SQLException 
	{
		
		
		conn=DbUtil.getConnection();
		
		
		
		
		String sql="Select * from user_details where user_id=? and login_password=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setInt(1,bean.getUserId());
		pst.setString(2,bean.getLoginPassword());
		
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()==false)
		{
			return false;
		}
		else
		{		
			if(rs.getString(7).equals("N"))
			{
				return false;
			}
			else
			{
				return true;
			}
			
		}
		
		
		
		
	}





	@Override
	public ArrayList<UserBean> changePassword(UserBean bean) throws IOException, SQLException
	{
		ArrayList<UserBean> list=new ArrayList<UserBean>();
		conn=DbUtil.getConnection();
		String secretQuestionAnswer="null";
		String secretQuestion="null";

		String sql="Select * from user_details where user_id=?";
		
		PreparedStatement pst=conn.prepareStatement(sql);
		
		pst.setInt(1,bean.getUserId());
		
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			
			 
			secretQuestion =rs.getString(4);
			secretQuestionAnswer=rs.getString(5);
			
		}
		
		list.add(new UserBean(secretQuestion,secretQuestionAnswer));	
			
		return list;
			
	
	}





	@Override
	public int updatePassword(UserBean bean) throws SQLException, IOException 
	{
		conn=DbUtil.getConnection();
		String updateQuery="update user_details set login_password=? where user_id=?";
		
		
		
		PreparedStatement ps=conn.prepareStatement(updateQuery);
		
		if(bean.getLoginPassword()==null)
		{
			ps.setString(1,"sbq500#");
			
			ps.setInt(2,bean.getUserId());
		}
		else
		{
			ps.setString(1,bean.getLoginPassword());
			
			ps.setInt(2,bean.getUserId());
		}
		
		
		int result=ps.executeUpdate();
		return result;
	}





	@Override
	public int updateLock(UserBean bean) throws IOException, SQLException {
		
		conn=DbUtil.getConnection();
		String updateQuery="update user_details set lock_status=? where user_id=?";
		
		
		
		PreparedStatement ps=conn.prepareStatement(updateQuery);
		
		
	
			ps.setString(1,"N");
			
			ps.setInt(2,bean.getUserId());
		
		
		
		int lockResult=ps.executeUpdate();
		return lockResult;
		
		
		
	}
	
	
		
		
}
	
	


