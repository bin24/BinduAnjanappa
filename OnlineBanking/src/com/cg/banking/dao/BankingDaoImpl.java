package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.UserBean1;
import com.cg.banking.dbUtil.dbUtil;



public class BankingDaoImpl implements IBankingDao {

	@Override
	public int createNewAcc(UserBean ub) throws IOException, SQLException {
		int nr = 0;
		Connection con = dbUtil.getConnection();
		
		String str = "INSERT Into Account_Master values(Account_id.nextval,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(str);
		pst.setString(1,ub.getName());
		pst.setInt(2,ub.getAcctype());
		pst.setInt(3,ub.getAccbal());
		pst.setDate(4,ub.getDate());
		pst.setString(5,ub.getAddress());
		pst.setString(6,ub.getMobileno());
		pst.setString(7,ub.getEmail());
		nr = pst.executeUpdate();
		int accid = 0;
		//System.out.println(nr);
		
		
			String sql = "select Account_id.currval from Account_Master";
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(sql);
			while(r.next())
			{
				accid = r.getInt(1);
			}
		
		//System.out.println("ID is "+);
		return accid;
	}

	@Override
	public ArrayList<UserBean1> reteriveDaily() throws IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		String str = "Select * From Transactions  WHERE (trunc(sysdate)=trunc(dateoftransaction))";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
	UserBean1 ubean = null;
		ArrayList<UserBean1> al = new ArrayList<UserBean1>();
		
		while(rs.next()){
			
			 int transactionID = rs.getInt(1);
	
			 String trandescription = rs.getString(2);
			
			 Date dateofTransaction = rs.getDate(3);
			 String transactionType = rs.getString(4);
			
			 int tranAmount = rs.getInt(5);
			
			 int accountNo = rs.getInt(6);
			
			
			 al.add(new UserBean1(transactionID, trandescription, dateofTransaction, transactionType, tranAmount, accountNo));			
		}
		
	//	System.out.println(al);
		return al;
	}

	@Override
	public ArrayList<UserBean1> reteriveMonthly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		String str = "SELECT * FROM Transactions WHERE (trunc(sysdate)-trunc(dateoftransaction)<=30)";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
	UserBean1 ubean = null;
		ArrayList<UserBean1> al = new ArrayList<UserBean1>();
		
		while(rs.next()){
			
			 int transactionID = rs.getInt(1);
	
			 String trandescription = rs.getString(2);
			
			 Date dateofTransaction = rs.getDate(3);
			 String transactionType = rs.getString(4);
			
			 int tranAmount = rs.getInt(5);
			
			 int accountNo = rs.getInt(6);
			
			
			 al.add(new UserBean1(transactionID, trandescription, dateofTransaction, transactionType, tranAmount, accountNo));			
		}
		
	//	System.out.println(al);
		return al;
	}

	@Override
	public ArrayList<UserBean1> reteriveYearly() throws IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con = dbUtil.getConnection();
		String str = "SELECT * FROM Transactions WHERE (trunc(sysdate)-trunc(dateoftransaction)<=365)";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(str);
	UserBean1 ubean = null;
		ArrayList<UserBean1> al = new ArrayList<UserBean1>();
		
		while(rs.next()){
			
			 int transactionID = rs.getInt(1);
	
			 String trandescription = rs.getString(2);
			
			 Date dateofTransaction = rs.getDate(3);
			 String transactionType = rs.getString(4);
			
			 int tranAmount = rs.getInt(5);
			
			 int accountNo = rs.getInt(6);
			
			
			 al.add(new UserBean1(transactionID, trandescription, dateofTransaction, transactionType, tranAmount, accountNo));			
		}
		
	//	System.out.println(al);
		return al;	}

}
