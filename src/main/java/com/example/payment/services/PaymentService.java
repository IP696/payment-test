package com.example.payment.services;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.PaymentResponse;

public interface PaymentService {
  PaymentResponse processPayment(PaymentRequest paymentRequest);
}
