package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;

@Mapper
public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와 일치
	 * StudentMapper.xml을 StudentMapper 인터페이스와 같은 위치에 둠
	 * 메쏘드 이름은 	StudentMapper.xml 파일의 id와 일치
	 * 메쏘드 인자타입은 StudentMapper.xml 파일의 parameterType과 일치
	 * 메쏘드 리턴타입은 StudentMapper.xml 파일의 resultType과 일치(ResultSet이 1개 이상일 경우는 List)
	 */
	public Student findStudentById(Integer studId);
	
	public List<Student> findAllStudents();
	
	public String findStudentNameById(Integer studId);
	
	public List<String> findStudentNameList();
	
	public int insertStudent(Student student);
	
	public int insertStudentBySequence1(Student student);
	
	/*
	<insert id="insertStudentBySequence2" parameterType="com.mybatis3.domain.Student">
		<selectKey order="BEFORE" resultType="int" keyProperty="studId">
			select students_stud_id_seq.nextval from dual
		</selectKey>
		insert into students(stud_id, name, email, dob)
			values (#{studId},#{name},#{email},#{dob})
	</insert>
	 */
	@SelectKey(statement = "select students_stud_id_seq.nextval from dual", 
				before = true, 
				resultType = Integer.class,
				keyProperty = "studId")
	@Insert("insert into students(stud_id, name, email, dob) values (#{student.studId},#{student.name},#{student.email},#{student.dob})")
	public int insertStudentBySequence2(@Param("student")Student student);
	
	public int updateStudentById(Student student);

	public int deleteStudentById(Integer studId);

	public Student findStudentByIdWithAddress(Integer studId);
	
	
	
	/*
	<select id="findStudentByIdWithCourses" 
			parameterType="java.lang.Integer"
			resultMap="studentWithCoursesResultMap">
		select s.stud_id, s.name as student_name, email, dob, 
				c.course_id, c.name as course_name, description, start_date, end_date
		from students s 
		join course_enrollment ce
		on s.stud_id = ce.stud_id
		join courses c
		on ce.course_id=c.course_id where s.stud_id=#{studId}
	</select>
	 */
	@ResultMap("studentWithCoursesResultMap")
	@Select("select s.stud_id, s.name as student_name, email, dob,"
			+ "			c.course_id, c.name as course_name, description, start_date, end_date\r\n"
			+ "		from students s \r\n"
			+ "		join course_enrollment ce\r\n"
			+ "		on s.stud_id = ce.stud_id\r\n"
			+ "		join courses c\r\n"
			+ "		on ce.course_id=c.course_id where s.stud_id=#{studId}")
	public Student findStudentByIdWithCourses(@Param("studId") Integer studId);
	
}
