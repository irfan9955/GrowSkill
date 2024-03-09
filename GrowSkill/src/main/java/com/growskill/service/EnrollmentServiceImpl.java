package com.growskill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.entity.Enrollment;
import com.growskill.exceptoin.EnrollmentException;
import com.growskill.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) throws EnrollmentException {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        return optionalEnrollment.orElseThrow(() -> new EnrollmentException("Enrollment not found"));
    }

    @Override
    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Long id, Enrollment enrollment) throws EnrollmentException {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        if (optionalEnrollment.isPresent()) {
            enrollment.setId(id); // Ensure the provided enrollment ID matches the path variable
            return enrollmentRepository.save(enrollment);
        } else {
            throw new EnrollmentException("Enrollment not found");
        }
    }

    @Override
    public boolean deleteEnrollment(Long id) throws EnrollmentException {
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(id);
        if (optionalEnrollment.isPresent()) {
            enrollmentRepository.deleteById(id);
            return true;
        } else {
            throw new EnrollmentException("Enrollment not found");
        }
    }
}
