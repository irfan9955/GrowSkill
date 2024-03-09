package com.growskill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.entity.Payment;
import com.growskill.exceptoin.PaymentException;
import com.growskill.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) throws PaymentException {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElseThrow(() -> new PaymentException("Payment not found"));
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) throws PaymentException {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            payment.setId(id); // Ensure the provided payment ID matches the path variable
            return paymentRepository.save(payment);
        } else {
            throw new PaymentException("Payment not found");
        }
    }

    @Override
    public boolean deletePayment(Long id) throws PaymentException {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            paymentRepository.deleteById(id);
            return true;
        } else {
            throw new PaymentException("Payment not found");
        }
    }
}
