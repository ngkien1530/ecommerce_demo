package com.ecommerce.demo.payment.service.connector;

import com.ecommerce.demo.payment.adapter.visa.model.VisaPaymentRequest;
import com.ecommerce.demo.payment.adapter.visa.model.VisaPaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment-mock-service")
public interface VisaFeignConnector {

  @RequestMapping(method = RequestMethod.POST, value = "/api/pay")
  VisaPaymentResponse pay(VisaPaymentRequest request);
}
