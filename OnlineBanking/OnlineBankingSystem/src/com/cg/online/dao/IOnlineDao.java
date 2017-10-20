package com.cg.online.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.online.dto.OnlineBean;

public interface IOnlineDao {

	ArrayList<OnlineBean> retriveDetails(int id, java.time.LocalDate startdate, java.time.LocalDate enddate) throws SQLException, IOException;

	ArrayList<OnlineBean> retriveLast(int id) throws SQLException, IOException;

	

	

}
