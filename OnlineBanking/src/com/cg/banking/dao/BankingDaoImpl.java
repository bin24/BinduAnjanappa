package com.cg.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.banking.bean.UserBean;
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
		pst.setString(4,ub.getDate());
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

}
