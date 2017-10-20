package com.cg.online.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.online.dto.OnlineBean;

public interface IOnlineService {

	ArrayList<OnlineBean> retriveDetails(int id, java.time.LocalDate startdate, java.time.LocalDate startdate2) throws SQLException, IOException;

	ArrayList<OnlineBean> retriveLast(int id) throws SQLException, IOException;

}
