package com.cg.online.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.online.dto.OnlineBean;

public interface IOnlineService {

	ArrayList<OnlineBean> retriveDetails(int id, Date startdate, Date enddate) throws SQLException, IOException;

}
