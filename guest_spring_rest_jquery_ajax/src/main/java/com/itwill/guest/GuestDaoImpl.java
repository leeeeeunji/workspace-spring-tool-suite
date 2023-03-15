package com.itwill.guest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.guest.mapper.GuestMapper;
@Repository
public class GuestDaoImpl  implements GuestDao{
	@Autowired
	private GuestMapper guestMapper;
	
	public GuestDaoImpl(GuestMapper guestMapper) throws Exception {
		this.guestMapper=guestMapper;
	}
	public GuestDaoImpl() {
		System.out.println("GuestDaoImplMyBatisMapperInterface");
	}
	public GuestMapper getGuestMapper() {
		return guestMapper;
	}

	public void setGuestMapper(GuestMapper guestMapper) {
		this.guestMapper = guestMapper;
	}
	/*
	 * READ ALL
	 */
	public List<Guest> selectAll() throws Exception {
		System.out.println(">>GuestDaoImplMyBatisMapperInterface");
		List<Guest> guestList=guestMapper.selectAll();
		return guestList;
	}
	/*
	 * CREATE
	 */
	public int insertGuest(Guest guest) throws Exception {
		guestMapper.insertGuest(guest); 
		return guest.getGuest_no();
	}
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		Guest guest=guestMapper.selectByNo(no);
		return guest;
	}
	
	/*
	 /*
	 * DELETE
	 */
	public int deleteGuest(int guest_no) throws Exception{
		
		int deleteRowCount=guestMapper.deleteGuest(guest_no); 
		return deleteRowCount;
	}
	/*
	 * UPDATE
	 */
	public int updateGuest(Guest updateGuest) throws Exception{
		int updateRowCount=guestMapper.updateGuest(updateGuest);
		return updateRowCount;
	}
}










