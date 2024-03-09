package com.growskill.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.entity.Course;
import com.growskill.exceptoin.CourseException;
import com.growskill.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) throws CourseException {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElseThrow(() -> new CourseException("Course not found"));
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) throws CourseException {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            course.setId(id); // Ensure the provided course ID matches the path variable
            return courseRepository.save(course);
        } else {
            throw new CourseException("Course not found");
        }
    }

    @Override
    public void deleteCourse(long id) throws CourseException {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        try {
			if (optionalCourse.isPresent()) {
			    courseRepository.deleteById(id);
			} else {
			    throw new CourseException("Course not found");
			}
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
