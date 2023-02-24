package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
@Repository(value = "guestDao")
//Conponent 붙여도 됨
@Scope(scopeName = "singleton")
//디폴드값이라 싱글톤 안써도 됨
public class GuestDaoImpl implements GuestDao {
	
	public GuestDaoImpl() {
		System.out.println("2.#### GuestDaoImpl() 기본생성자호출");
	}
	
	@Override
	public List<Guest> selectAll()
			throws Exception{
		System.out.println("#### GuestDaoImpl : selectAll() 호출");
		return null;
	}
	
	@Override
	public Guest selectByNo(int no)throws Exception{
		System.out.println("#### GuestDaoImpl : selectByNo(int no) 호출");
		Guest guest=null;
		
		return guest;
	}
	@Override
	public int insertGuest(Guest guest)throws Exception {
		System.out.println("#### GuestDaoImpl : insertGuest(Guest guest) 호출");
		return 0;
		
	}
	@Override
	public int updateGuest(Guest guest)throws Exception {
		System.out.println("#### GuestDaoImpl : updateGuest(Guest guest) 호출");
		return 0;
		
	}
	@Override
	public int deleteGuest(int no)throws Exception {
		System.out.println("#### GuestDaoImpl : deleteGuest(int no) 호출");
		return 0;
	}
	
	
	
}
