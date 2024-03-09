package com.growskill.service;

import java.util.List;

import com.growskill.entity.Course;
import com.growskill.exceptoin.CourseException;

public interface CourseService {
	
	public List<Course> getAllCourses();
	
	public Course getCourseById(Long id) throws CourseException;
	
	public Course createCourse(Course course);
	
	public Course updateCourse(Long id,Course course) throws CourseException;
	
	public void deleteCourse(long id) throws CourseException;

}
