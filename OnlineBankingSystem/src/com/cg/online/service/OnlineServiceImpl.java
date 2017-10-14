package com.cg.online.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.online.dao.IOnlineDao;
import com.cg.online.dao.OnlineDaoImpl;
import com.cg.online.dto.OnlineBean;

public class OnlineServiceImpl implements IOnlineService {

	IOnlineDao dao=new OnlineDaoImpl();
	@Override
	public ArrayList<OnlineBean> retriveDetails() throws SQLException, IOException {
		 ArrayList<OnlineBean> al=dao.retriveDetails();
		 return al;
	}

}
