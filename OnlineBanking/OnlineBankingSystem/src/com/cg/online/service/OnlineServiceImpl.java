package com.cg.online.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.online.dao.IOnlineDao;
import com.cg.online.dao.OnlineDaoImpl;
import com.cg.online.dto.OnlineBean;

public class OnlineServiceImpl implements IOnlineService {

	IOnlineDao dao=new OnlineDaoImpl();
	/*@Override
	public ArrayList<OnlineBean> retriveDetails(int id, Date startdate, Date enddate) throws SQLException, IOException {
		 ArrayList<OnlineBean> al=dao.retriveDetails(id,startdate,enddate);
		 return al;
	}*/

	@Override
	public ArrayList<OnlineBean> retriveDetails(int id, java.time.LocalDate startdate,
			java.time.LocalDate enddate) throws SQLException, IOException {
		 ArrayList<OnlineBean> al=dao.retriveDetails(id,startdate,enddate);
		 return al;
	}

	@Override
	public ArrayList<OnlineBean> retriveLast(int id) throws SQLException, IOException {
		ArrayList<OnlineBean> al=dao.retriveLast(id);
		 return al;
	}

	

}
