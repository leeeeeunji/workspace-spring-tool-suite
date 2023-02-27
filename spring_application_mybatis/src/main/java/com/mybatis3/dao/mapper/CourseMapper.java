package com.mybatis3.dao.mapper;

import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Course;

public interface CourseMapper {
	@Select("select * from course where course_id=#{courseId}")
	public Course findCourseById(Integer course_id);
}
