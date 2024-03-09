package com.growskill.exceptoin;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetail> userExceptionHandler(UserException ue,WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ue.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EnrollmentException.class)
	public ResponseEntity<MyErrorDetail> productExceptionHandler(EnrollmentException pe,WebRequest wr){
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pe.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<MyErrorDetail> categorysExceptionHandler(PaymentException ce,WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SessionException.class)
	public ResponseEntity<MyErrorDetail> CartItemExceptionHandler(SessionException ce,WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetail> OrderItemExceptionHandler(CourseException ce,WebRequest wr){
		
		MyErrorDetail err = new MyErrorDetail();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	
	
}
