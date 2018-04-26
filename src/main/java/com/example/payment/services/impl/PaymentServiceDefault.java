package com.example.payment.services.impl;

import com.example.payment.dto.PaymentRequest;
import com.example.payment.dto.PaymentResponse;
import com.example.payment.dto.PaymentType;
import com.example.payment.services.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceDefault implements PaymentService {
  @Override
  public PaymentResponse processPayment(PaymentRequest paymentRequest) {

    PaymentType paymentType = paymentRequest.getPaymentType();
    switch (paymentType) {
    case PERSONAL_ACCOUNT_NUMBER:
      return payByAccountNumber(paymentRequest);
    case CARD:
      return payByCard(paymentRequest);
    default:
      throw new IllegalArgumentException("type not recognized!");
    }
  }

  private PaymentResponse payByAccountNumber(PaymentRequest paymentRequest) {
    PaymentResponse paymentResponse = new PaymentResponse();
    paymentResponse.setStatus("OK");
    paymentResponse
      .setDescription("Pay by: " + paymentRequest.getPersonalAccountNumber() + " to: " + paymentRequest.getAmount());
    return paymentResponse;
  }

  private PaymentResponse payByCard(PaymentRequest paymentRequest) {
    PaymentResponse paymentResponse = new PaymentResponse();
    paymentResponse.setStatus("OK");
    paymentResponse.setDescription(
      "Pay by: " + paymentRequest.getCardNumber() + ":" + paymentRequest.getCardExpiredDate() + " to: " + paymentRequest
        .getAmount());
    return paymentResponse;
  }
}
