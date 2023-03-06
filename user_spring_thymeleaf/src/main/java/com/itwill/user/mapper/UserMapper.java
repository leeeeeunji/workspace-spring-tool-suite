package com.itwill.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.user.User;
@Mapper
public interface UserMapper {
	/*
	<insert id="create" parameterType="com.itwill.user.User">
		insert into userinfo(userid,password,name,email) values(#{userId},#{password},#{name},#{email})
	</insert>
	*/
	
	public int create(User user);
	/*
	<update id="update" parameterType="com.itwill.user.User">
		update  userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}
	</update>
	*/
	public int update(User user);
	/*
	<delete id="remove" parameterType="int">
		delete userinfo where userid=#{userId}
	</delete>
	 */
	public int remove(String userId);
	/*
	<select id="findUser" parameterType="string" resultType="com.itwill.user.User">
		select userid,password,name,email from userinfo where userid=#{userId}
	</select>
   */
	public User findUser(String userId);
	/*
	<select id="findUserList" resultType="com.itwill.user.User">
		select userid,password,name,email from userinfo
	</select>
   */
	public List<User> findUserList();
	/*
	<select id="findUserCount" parameterType="string" resultType="int">
		select count(*) cnt from userinfo where userid=#{userId}
	</select>
	*/
	public int existedUser(String userId);
	
}