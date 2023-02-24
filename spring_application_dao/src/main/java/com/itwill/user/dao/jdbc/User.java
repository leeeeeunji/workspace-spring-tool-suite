package com.itwill.user.dao.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	/*
	 * =================================== 
	 * 이름 		널? 		유형
	 * =================================== 
	 * USERID 	NOT NULL VARCHAR2(100) 
	 * PASSWORD	NOT NULL VARCHAR2(100) 
	 * NAME 	NOT NULL VARCHAR2(200) 
	 * EMAIL 			 VARCHAR2(300)
	 * ===================================
	 */
	
	private String userId;
	private String password;
	private String name;
	private String email;
	/*
	public User() {
		System.out.println("1.#### User()기본생성자");
	}

	public User(String userId, String password, String name, String email) {
		System.out.println("1.#### User(String userId, String password, String name, String email) 생성자");
		
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("2.#### User.setUserId(String userId) 메쏘드호출");
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("2.#### User.setPassword(String password) 메쏘드호출");
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("2.#### User.setName(String name) 메쏘드호출");
		this.name = name;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		System.out.println("2.#### User.setEmail(String email) 메쏘드호출");
		this.email = email;
	}
	*/
	/*
	 *패쓰워드 일치여부 검사 
	 */
	/*
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	*/
}







