package com.payment.rider.driver.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.payment.rider.driver.dto.PayMethodDTO;
import com.payment.rider.driver.dto.TransactionDTO;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.IPaymentGateway;

@Service
public class PaymentGatewayImpl implements IPaymentGateway{

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${spring.external.service.base-url}")
	private String baseUrl;
	
	@Override
	public String getAcceptToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonNode createPaySource(PayMethodDTO payMethodDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonNode createTransaction(TransactionDTO transactionDTO, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String statusTransaction(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
