package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.user.mapper.UserMapper;
@Repository(value = "userDaoImplMyBatisMapperInterface")
public class UserDaoImpl implements UserDao {
	
	@Autowired(required = false)
	private UserMapper userMapper;

	public UserDaoImpl() {
		System.out.println("#### UserDaoImplMyBatisMapperInterface() : 디폴트생성자 호출  ");
	}
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		System.out.println("#### UserDaoImplMyBatisMapperInterface() : setUserMapper() 메쏘드호출  ");
		this.userMapper = userMapper;
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : create() 호출  ");

		return userMapper.create(user);
	}

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : update() 호출  ");

		return userMapper.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : remove() 호출  ");

		return userMapper.remove(userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUser() 호출  ");

		return userMapper.findUser(userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUserList 호출  ");

		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : existedUser 호출  ");
			
		int count=userMapper.existedUser(userId);
		if(count==1) {
			return true;
		}else {
			return false;
		}
		
	}

}