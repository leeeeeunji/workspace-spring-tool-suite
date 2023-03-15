package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestDao guestDao;
	
	public GuestServiceImpl() throws Exception {
		System.out.println(">>GuestServiceImpl");
	}
	
	public GuestDao getGuestDao() {
		return guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	/*
	 * Create
	 */
	@Override
	public int insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * Read
	 */
	@Override
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	@Override
	public List<Guest> selectAll() throws Exception{
		return guestDao.selectAll();
	}
	/*
	 * Update
	 */
	@Override
	public int updateGuest(Guest guest) throws Exception{
		return guestDao.updateGuest(guest);
	}
	/*
	 * Delete
	 */
	@Override
	public int deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
}
