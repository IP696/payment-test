package com.example.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentRequest {
  private String personalAccountNumber;
  private String cardNumber;
  private Date cardExpiredDate;
  private BigDecimal amount;
  private String description;
  private PaymentType paymentType;
}
