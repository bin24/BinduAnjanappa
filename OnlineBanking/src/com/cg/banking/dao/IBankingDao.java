package com.cg.banking.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.banking.bean.UserBean;
import com.cg.banking.bean.UserBean1;

public interface IBankingDao {

	int createNewAcc(UserBean ub) throws IOException, SQLException;

	ArrayList<UserBean1> reteriveDaily() throws IOException, SQLException;

	ArrayList<UserBean1> reteriveMonthly() throws IOException, SQLException;

	ArrayList<UserBean1> reteriveYearly() throws IOException, SQLException;

}
