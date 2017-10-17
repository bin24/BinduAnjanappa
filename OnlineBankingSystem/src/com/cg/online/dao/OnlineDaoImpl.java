package com.cg.online.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;













import com.cg.online.dbutil.DBUtil;
import com.cg.online.dto.OnlineBean;

public class OnlineDaoImpl implements IOnlineDao {

	@Override
	public ArrayList<OnlineBean> retriveDetails(int id, java.time.LocalDate startdate,java.time.LocalDate enddate) throws SQLException, IOException {
		
		System.out.println("Your id is "+id);
		System.out.println(startdate);	
		 
		 
			int day = startdate.getDayOfMonth();
			Month month = startdate.getMonth();
			int year = startdate.getYear();
			String sDateToPass = day +"-"+month+"-"+ year;
			
			System.out.println(sDateToPass);
		System.out.println(enddate);	
			 
			 
			 day = enddate.getDayOfMonth();
			 month = enddate.getMonth();
			 year = enddate.getYear();
			String eDateToPass = day +"-"+month+"-"+ year;

			System.out.println(eDateToPass);
			
			Connection conn=DBUtil.getConnection();
			String sql="Select * from Transactions where account_no=? and DATE_OF_TRANSACTION >=? and DATE_OF_TRANSACTION <=?";
			ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.setString(2, sDateToPass);
			stmt.setString(3, eDateToPass);
			
			System.out.println("IN DAO");
			
			
			ResultSet rs=stmt.executeQuery();
		
			while(rs.next())
			{
				System.out.println("in While Start");
				int tid=rs.getInt(1);
				System.out.println(tid);
				String desc=rs.getString(2);
				Date dat=rs.getDate(3);
				String transType=rs.getString(4);
				int transAmount=rs.getInt(5);
				list.add(new OnlineBean(tid,desc,dat,transType,transAmount));
				System.out.println("in While End");
			}
			
			System.out.println(list);
			return list;
		
	
	}

	
	
}
		