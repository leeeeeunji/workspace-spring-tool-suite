package com.mybatis3.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

@Repository
public class StudentDao {
	@Autowired
	private StudentMapper studentMapper;
	
	public StudentDao() {
	}
	/**************************************************
	 * SELECT
	 **************************************************/
	/*
	 * A.select sql의 결과 타입이 DTO,VO,Domain객체인 경우 resultType : DTO,VO,Domain
	 */
	public Student findStudentById(Integer studId) {
		return studentMapper.findStudentById(studId);
	}

	public List<Student> findAllStudents() {
		return studentMapper.findAllStudents();
	}
	
	/*
	 * B.select sql의 결과 타입이 String, Wrapper객체인 경우 resultType : java.lang.String, java.lang.Integer
	 */
	public String findStudentNameById(Integer userId) {
		return studentMapper.findStudentNameById(userId);
	}

	public List<String> findStudentNameList() {
		return studentMapper.findStudentNameList();
	}
	
	
	
	/***********************************
	 * INSERT
	 ***********************************/
	public int insertStudent(Student student) {
		return studentMapper.insertStudent(student);
	}

	public int insertStudentBySequence1(Student student) {
		return studentMapper.insertStudentBySequence1(student);
	}

	/*
	 * sequence실행후 PK return
	 */
	public int insertStudentBySequence2(Student student) {
		return studentMapper.insertStudentBySequence2(student);
	}
	
	
	/***********************************
	 * UPDATE
	 ***********************************/
	public int updateStudentById(Student student) {
		return studentMapper.updateStudentById(student);
	}
	
	
	/***********************************
	 * DELETE
	 ***********************************/
	public int deleteStudentById(Integer studId) {
		return studentMapper.deleteStudentById(studId);
	}
	
	public int deleteStudentByName(String name) {
		return 0;
	}
	
	public int deleteStudentByNameLike(String name) {
		return 0;
	}
	
	
	
	/**************************************************
	 * 결과데이타를 Map(HashMap)에 담아서 반환할수있다
	 ***************************************************/
	public Map findStudentByIdMap(Integer studId) {
		return null;
	}

	public List<Map> findAllStudentsMapList() {
		return null;
	}



	
	/**************************************************
	 * SELECT[students + addresses JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * select sql의 결과 타입이 DTO,VO,Domain객체인 경우 
	 * resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		return studentMapper.findStudentByIdWithAddress(studId);
	}
	
	
	/**************************************************
	 * SELECT[students + courses[course_enrollment] JOIN( 1 : N )
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우 resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		return studentMapper.findStudentByIdWithCourses(studId);
	}
	

	/**************************************************
	 * SELECT[students + address + courses[course_enrollment] JOIN( 1 : 1 : N )
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우 resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithAddressWithCourses(Integer studId) {
		return null;
	}


	/*
	 * B.select sql의결과타입이 DTO,VO,Domain객체인경우 resultMap : DTO,VO,Domain
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		return null;
	}

	public List<Student> findAllStudentsResultMap() {
		return null;
	}

	public List<Student> findStudentByIdRangeParamMap(HashMap idRangeMap) {
		return null;
	}
	public List<Student> findStudentsThreeParamMap(HashMap studentsMap) {
		return null;
	}
	public int updateStudentParamMap(Map studentMap) {
		return 0;
	}

}
