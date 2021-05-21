package com.ecommerce.demo.payment.model;

public enum PaymentStatus {
  IN_PROGRESS("Payment Pending"),
  FAILED("Failed"),
  SUCCEED("Success");

  public String getStatusReadable() {
    return statusReadable;
  }

  private String statusReadable;

  PaymentStatus(String statusReadable) {
    this.statusReadable = statusReadable;
  }
}
