package com.example.payment.controllers;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.PaymentResponse;
import com.example.payment.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("pay")
  public PaymentResponse pay(@RequestBody PaymentRequest paymentRequest) {
    return paymentService.processPayment(paymentRequest);
  }
}
