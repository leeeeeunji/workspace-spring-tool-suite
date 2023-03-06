package com.itwill.guest;

import java.util.List;

public interface GuestDao {

	int insertGuest(Guest guest) throws Exception;

	Guest selectByNo(int no) throws Exception;

	List<Guest> selectAll() throws Exception;

	int updateGuest(Guest guest) throws Exception;

	int deleteGuest(int no) throws Exception;

}