package com.growskill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growskill.entity.Enrollment;
import com.growskill.exceptoin.EnrollmentException;
import com.growskill.service.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class Enrollmentcontroller {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) throws EnrollmentException {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);
        if (enrollment != null) {
            return new ResponseEntity<>(enrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) throws EnrollmentException {
        Enrollment updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);
        if (updatedEnrollment != null) {
            return new ResponseEntity<>(updatedEnrollment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) throws EnrollmentException {
        boolean deleted = enrollmentService.deleteEnrollment(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

