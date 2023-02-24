package com.itwill.user;

import java.util.List;
public interface UserService{
	public int create(User user) throws Exception;
	public int update(User user)throws Exception;
	public int remove(String userId)throws Exception;
	public User findUser(String userId)	throws Exception;
	public List<User> findUserList()throws Exception;
	public User login(String userId, String password)throws Exception;
}