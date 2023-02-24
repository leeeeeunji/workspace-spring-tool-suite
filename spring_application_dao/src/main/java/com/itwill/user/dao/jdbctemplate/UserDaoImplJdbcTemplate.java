package com.itwill.user.dao.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwill.user.dao.jdbc.UserSQL;

@Repository
public class UserDaoImplJdbcTemplate implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(User user) throws Exception {
		
		return jdbcTemplate.update(UserSQL.USER_INSERT, 
									user.getUserId(), 
									user.getPassword(), 
									user.getName(), 
									user.getEmail());
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
