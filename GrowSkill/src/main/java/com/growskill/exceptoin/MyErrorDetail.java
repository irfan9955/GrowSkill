package com.growskill.exceptoin;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MyErrorDetail {
	
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	public MyErrorDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public MyErrorDetail(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
