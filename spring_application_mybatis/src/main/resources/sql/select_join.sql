select dob from students;
select name from students where stud_id=1;
select STUDENTS_STUD_ID_SEQ.currval from dual;

/*
students + addresses[inner join]
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
FROM students s 
inner join addresses a 
on s.addr_id=a.addr_id;

/*
students + addresses [left outer join]
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
FROM students s 
left outer join addresses a 
on s.addr_id=a.addr_id;

/*
students + addresses [left outer join]
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
FROM students s 
left outer join addresses a 
on s.addr_id=a.addr_id where stud_id=1;

     

--findStudentByIdWithAddress--
/*
students + addresses join [1 : 1]
*/
select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      left outer join addresses a 
      on s.addr_id=a.addr_id
      where s.stud_id=1;

 
/*
addresses + students join [1 : n]
*/ 
select a.addr_id ,street,city,state,zip,country,stud_id,name,email,dob 
		from addresses a inner join students s 
		on a.addr_id=s.addr_id 
		where a.addr_id=8;

 
 
--findStudentByIdWithCourses 
/*
students + courses[course_enrollment]  join
*/     
select s.*,c.* 
		from students s 
		join course_enrollment ce
		on s.stud_id = ce.stud_id
		join courses c
		on ce.course_id=c.course_id where s.stud_id=1;

/*
students + courses[course_enrollment] join
*/
select  s.stud_id,s.name as student_name ,s.email,s.phone,s.dob ,
        c.course_id,c.name as course_name ,c.description,c.start_date,c.end_date
		from students s 
		left outer join course_enrollment ce
		on s.stud_id = ce.stud_id
		left outer join courses c
		on ce.course_id=c.course_id where s.stud_id=1;
		
       
----findCourseByIdWithStudents 
/*
courses + students[course_enrollment] join( 1 : N )
*/
select c.*,s.* from courses c 
		join course_enrollment ce on c.course_id=ce.course_id
		join students s on ce.stud_id=s.stud_id
		where c.course_id=3;


---findTutorByIdWithCourses       
/*
tutors + courses join[ 1 : N ]
*/
/*
inner join
*/
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      join courses c 
      on t.tutor_id=c.tutor_id; 
      
/*
outer join
*/      
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join courses c 
      on t.tutor_id=c.tutor_id;
      
      
           
SELECT t.tutor_id, t.name as tutor_name, email,course_id, c.name, description, start_date, end_date
      FROM tutors t 
      left outer join courses c 
      on t.tutor_id=c.tutor_id
      where t.tutor_id=1;  
      
/*
courses + tutors join[ 1 : 1 ]
개설된강의와 강사정보
*/
--inner join--
SELECT course_id, c.name, c.description, c.start_date, c.end_date,t.tutor_id, t.name as tutor_name, t.email
      FROM courses c  
      join tutors t
      on c.tutor_id=t.tutor_id;
 
SELECT course_id, c.name, c.description, c.start_date, c.end_date,t.tutor_id, t.name as tutor_name, t.email
      FROM courses c  
      join tutors t
      on c.tutor_id=t.tutor_id
where c.course_id = 1;
      
      
/*
students + addresses + courses 
*/
select s.*,a.*,
c.course_id,c.name as course_name,c.description,c.start_date,c.end_date 
from students s join addresses a 
on s.stud_id = a.addr_id 
join course_enrollment ce 
on s.stud_id=ce.stud_id
join courses c
on ce.course_id=c.course_id
where s.stud_id=1;
        
  
  

      
      
-- Courses검색      
SELECT * FROM COURSES
WHERE TUTOR_ID = 1
AND NAME LIKE '%Quick%'
AND START_DATE >= TO_DATE('2015/05/01');
      
      
      
      
      
      
      
      