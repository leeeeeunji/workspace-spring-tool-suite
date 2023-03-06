package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
@Service
public class UserServiceImpl implements UserService{
	

	
	@Autowired
	@Qualifier("userDaoImplMyBatisMapperInterface")
	private UserDao userDao;

	public UserServiceImpl() throws Exception {
		
	}
	/*
	 * 회원가입
	 */
	/**************1.반환값사용***********************/
	@Override
	public int create(User user)throws ExistedUserException,Exception{
		//1.아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			//아이디중복
			throw new ExistedUserException(user.getUserId()+" 는 이미 존재하는아이디입니다.");
		}
		//아이디안중복
		//2.회원가입
		return userDao.create(user);
	}
	/*********************************************/
	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공
	 */
	@Override
	public int login(String userId,String password) throws Exception,UserNotFoundException,PasswordMismatchException {
		int result=1;
		
		User user = userDao.findUser(userId);
		if(user==null) {
			//아이디존재안함
			throw new UserNotFoundException(userId+" 는 존재하지않는 아이디입니다.");
		}
		if(!user.isMatchPassword(password)){
			//패쓰워드불일치
			throw new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
		}
		return result;
	}
	/*
	 * 회원로그아웃
	 */
	
	/*
	 * 회원상세보기
	 */
	@Override
	public User findUser(String userId) throws Exception{
		return userDao.findUser(userId);
	}
	/*
	 * 회원수정
	 */
	@Override
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
	
	/*
	 * 회원탈퇴
	 */
	@Override
	public int remove(String userId) throws Exception{
		return userDao.remove(userId);
	}
	
	/*
	 * 전체회원리스트
	 */
	@Override
	public List<User> findUserList()throws Exception{
		return userDao.findUserList();
	}
	/*
	 * 아이디중복체크
	 */
	@Override
	public boolean isDuplicateId(String userId) throws Exception{
		boolean isExist = userDao.existedUser(userId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
}
















