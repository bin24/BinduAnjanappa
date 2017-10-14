package com.cg.online.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import java.util.Date;


import com.cg.online.dbutil.DBUtil;
import com.cg.online.dto.OnlineBean;

public class OnlineDaoImpl implements IOnlineDao {

	@Override
	public ArrayList<OnlineBean> retriveDetails() throws SQLException, IOException {
		
		Connection conn=DBUtil.getConnection();
		String sql="Select * from Transactions";
		ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		while(rs.next())
		{
			int id=rs.getInt(1);
			
			System.out.println(id);
			
			list.add(new OnlineBean());
		}
		
		
	/*	ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
		Connection conn=DBUtil.getConnection();
		System.out.println(conn);
		String sql="Select * from Transactions";
		
		
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next())
		{
			System.out.println("in while");
			
			int id=rs.getInt(1);
			System.out.println(id);
			String desc=rs.getString(2);
			Date dat=rs.getDate(3);
			String transType=rs.getString(4);
			int transAmount=rs.getInt(5);
			int accountNumber=rs.getInt(6);
			list.add(new OnlineBean(id,desc,dat,transType,transAmount,accountNumber));
			
		}*/
		return list;
		}
		}
		
	
