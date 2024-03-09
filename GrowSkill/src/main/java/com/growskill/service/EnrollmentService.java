package com.growskill.service;

import java.util.List;

import com.growskill.entity.Enrollment;
import com.growskill.exceptoin.EnrollmentException;

public interface EnrollmentService {
	
	public List<Enrollment> getAllEnrollments();
	
	public Enrollment getEnrollmentById(Long id) throws EnrollmentException;
	
	public Enrollment createEnrollment(Enrollment enrollment);
	
	public  Enrollment updateEnrollment(Long id,Enrollment enrollment) throws EnrollmentException;
	
	public boolean deleteEnrollment(Long id) throws EnrollmentException;

}
