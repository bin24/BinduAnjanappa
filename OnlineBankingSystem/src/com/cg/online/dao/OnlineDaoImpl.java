package com.cg.online.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;








import com.cg.online.dbutil.DBUtil;
import com.cg.online.dto.OnlineBean;

public class OnlineDaoImpl implements IOnlineDao {

	@Override
	public ArrayList<OnlineBean> retriveDetails(int id,Date startdate,Date enddate) throws SQLException, IOException {
		
		Connection conn=DBUtil.getConnection();
		String sql="Select * from Transactions where date_of_transaction between =? and = ? and account_no=?";
		ArrayList<OnlineBean> list=new ArrayList<OnlineBean>();
		PreparedStatement stmt=conn.prepareStatement(sql);
		
		stmt.setDate(1,startdate);
		stmt.setDate(2,enddate);
		stmt.setInt(3, id);
		
		ResultSet rs=stmt.executeQuery();
		
		while(rs.next())
		{
			int tid=rs.getInt(1);
			System.out.println(tid);
			String desc=rs.getString(2);
			Date dat=rs.getDate(3);
			String transType=rs.getString(4);
			int transAmount=rs.getInt(5);
			
			list.add(new OnlineBean(tid,desc,dat,transType,transAmount));
		}
		return list;
		}
		}
		
	
