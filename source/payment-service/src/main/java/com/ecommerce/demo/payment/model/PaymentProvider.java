package com.ecommerce.demo.payment.model;

public enum PaymentProvider {
  VISA("visa"),
  MASTERCARD("mastercard");

  private String provider;

  public String getProvider() {
    return provider;
  }

  PaymentProvider(String provider) {
    this.provider = provider;
  }
}
