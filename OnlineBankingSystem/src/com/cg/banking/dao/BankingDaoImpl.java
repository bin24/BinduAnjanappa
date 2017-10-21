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

	
	public ArrayList<UserBean> getAddr(int accNo) {
		ArrayList<UserBean> addr=new ArrayList<UserBean>();
		try
		{
			Connection conn = DbUtil.getConnection();
			String str="select address,mobile_no from customer where account_id=?";
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setInt(1, accNo);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String address=rs.getString(1);
				long mob=rs.getLong(2);
				addr.add(new UserBean(address,mob));	
			}
			
		} 
		catch (IOException | SQLException e)
		{
			e.printStackTrace();
		}
		return addr;
	}

	public int changeAddr(UserBean bean) {
		int result=0;
		try
		{
			Connection conn = DbUtil.getConnection();
			String str="update customer set address=? where account_id=?";
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setString(1, bean.getAddress());
			ps.setInt(2, bean.getAccNo());

			result=ps.executeUpdate();
			
		} 
		catch (IOException | SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}

	@Override
	public int changeMob(UserBean bean) {
		int result=0;
		try
		{
			Connection conn = DbUtil.getConnection();
			String str="update customer set mobile_no=? where account_id=?";
			PreparedStatement ps=conn.prepareStatement(str);
			ps.setLong(1, bean.getMobile());
			ps.setInt(2, bean.getAccNo());

			result=ps.executeUpdate();
			
		} 
		catch (IOException | SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int checkAccId(int accNo) {

		int count=0;
		try {
			Connection conn = DbUtil.getConnection();
			String str="select account_id from customer";
			PreparedStatement ps=conn.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int acc_id=rs.getInt(1);
				if(acc_id==accNo)
				{
					count=1;
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
