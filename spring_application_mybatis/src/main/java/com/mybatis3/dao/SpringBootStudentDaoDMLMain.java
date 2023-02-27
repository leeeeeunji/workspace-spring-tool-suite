package com.mybatis3.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
@MapperScan(basePackages = "com.mabatis3.dao.mapper")
public class SpringBootStudentDaoDMLMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1 = new Student(100000, "김십만", "100000@gmail.com", new Date());
		System.out.println("### row count : " + studentDao.insertStudent(student1));
		
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2 = new Student(0, "시퀀스1", "seq1@gmail.com", new Date());
		System.out.println("### row count : " + studentDao.insertStudentBySequence1(student2));
		System.out.println("### pk -> " + student2.getStudId()); //-> 0나옴 = pk없음(StudentMapper 시퀀스1,2 차이점(selectkey) 참고)
		
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student3 = new Student(0, "시퀀스2", "seq2@gmail.com", new Date());
		System.out.println("### row count : " + studentDao.insertStudentBySequence2(student3));
		System.out.println("### pk -> " + student3.getStudId()); // pk출력됨 = pk있음
		System.out.println("### " + student3.getStudId() + "번 pk student : " + studentDao.findStudentById(student3.getStudId()));
		
		System.out.println("---------updateStudentById---------------------------");
		Student updateStudent = studentDao.findStudentById(7);
		updateStudent.setName("변경");
		updateStudent.setEmail("change@naver.com");
		updateStudent.setDob(new SimpleDateFormat("yyyy/MM/dd").parse("1995/04/25"));
		System.out.println("### update row count : " + studentDao.updateStudentById(updateStudent));
		
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("update delete count : " + studentDao.deleteStudentById(100000));
		
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("---------deleteStudentByNameLike---------------------");

	}

}
