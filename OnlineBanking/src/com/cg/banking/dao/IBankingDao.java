package com.cg.banking.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.banking.bean.UserBean;

public interface IBankingDao {

	int requestforcheckbook(UserBean u) throws SQLException, IOException;

	int addDetails(UserBean u);

}
