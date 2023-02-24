package com.itwill.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value="userDao")
public class UserDaoImpl implements UserDao {
	

	public UserDaoImpl() {
		System.out.println("#### UserDaoImpl() : 디폴트생성자 호출  ");
	}



	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImpl : create() 호출  ");
		return 0;
	}

	
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImpl : update() 호출  ");
		return 0;
	}

	
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : remove() 호출  ");
		return 0;
	}
	
	
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : findUser() 호출  ");
		return null;
	}
	
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImpl : findUserList 호출  ");
		return null;
	}
	
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImpl : existedUser() 호출  ");
		return true;
	}
	
}














