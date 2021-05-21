package com.ecommerce.demo.order.model;

public enum TransactionStatus {
  IN_PROGRESS("Payment Pending"),
  FAILED("Failed"),
  SUCCEED("Success");

  public String getStatusReadable() {
    return statusReadable;
  }

  private String statusReadable;

  TransactionStatus(String statusReadable) {
    this.statusReadable = statusReadable;
  }
}
