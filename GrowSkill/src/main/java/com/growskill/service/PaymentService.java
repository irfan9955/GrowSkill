package com.growskill.service;

import java.util.List;

import com.growskill.entity.Payment;
import com.growskill.exceptoin.PaymentException;

public interface PaymentService {
	
	public List<Payment> getAllPayments();
	
	public Payment getPaymentById(Long id) throws PaymentException;

	public Payment createPayment(Payment payment);
	
	public  Payment updatePayment(Long id,Payment payment) throws PaymentException;
	
	public boolean deletePayment(Long id) throws PaymentException;
	
}
