package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestService {
	private GuestDao guestDao;
	public GuestService() {
		guestDao=new GuestDao();
	}
	public List<Guest> selectAll() throws Exception{
		return guestDao.selectAll();
	}

	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}

	public int insertGuest(Guest guest)throws Exception {
		return guestDao.insertGuest(guest);
	}

	public int updateGuest(Guest guest) throws Exception{
		return guestDao.updateGuest(guest);
	}

	public int deleteGuest(int no)throws Exception {
		return guestDao.deleteGuest(no);
	}
}
