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
			int day = startdate.getDayOfMonth();
			Month month = startdate.getMonth();
			int year = startdate.getYear();
			String sDateToPass = day +"-"+month+"-"+ year;
			day = enddate.getDayOfMonth();
			month = enddate.getMonth();
			year = enddate.getYear();
			String eDateToPass = day +"-"+month+"-"+ year;
			//System.out.println(eDateToPass);
			Connection conn=DBUtil.getConnection();
			String sql="Select * from Transactions where account_no=? and DATE_OF_TRANSACTION >=? and DATE_OF_TRANSACTION <=?";
			ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, sDateToPass);
			stmt.setString(3, eDateToPass);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				int tid=rs.getInt(1);
				String desc=rs.getString(2);
				Date dat=rs.getDate(3);
				String transType=rs.getString(4);
				int transAmount=rs.getInt(5);
				list.add(new OnlineBean(tid,desc,dat,transType,transAmount));
			}
			return list;
	}

	@Override
	public ArrayList<OnlineBean> retriveLast(int id) throws SQLException, IOException {
		Connection conn=DBUtil.getConnection();
		String sql="SELECT *  FROM (SELECT * FROM transactions ORDER  BY transaction_id DESC) WHERE ROWNUM <=3 and account_no=?";
		ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
		PreparedStatement stmt=conn.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			int tid=rs.getInt(1);
			String desc=rs.getString(2);
			Date dat=rs.getDate(3);
			String transType=rs.getString(4);
			int transAmount=rs.getInt(5);
			list.add(new OnlineBean(tid,desc,dat,transType,transAmount));
		}
		return list;
	}	
}
		