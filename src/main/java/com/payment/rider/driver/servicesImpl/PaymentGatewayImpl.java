package com.payment.rider.driver.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.payment.rider.driver.dto.PayMethodDTO;
import com.payment.rider.driver.dto.TransactionDTO;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.IPaymentGateway;

@Service
public class PaymentGatewayImpl implements IPaymentGateway{
	
	private static String PUBLIC_KEY = "/merchants/{publicKey}";
	private static String PAYMENT_SOURCE = "/payment_sources";
	private static String STATUS_TRANSACTION = "/transactions/{transactionId}";
	private static String CREATE_TRANSACTION = "/transactions";

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${spring.external.service.base-url}")
	private String baseUrl;
	
	@Value("${spring.external.service.public-key}")
	private String publicKey;
	
	@Value("${spring.external.service.private-key}")
	private String privateKey;
	
	@Override
	@SuppressWarnings("null")
	public String getAcceptToken() {
		
		String fullPath = baseUrl + PUBLIC_KEY;
		
		String acceptanceToken = restTemplate.getForEntity(fullPath, JsonNode.class, publicKey).getBody().get("data")
				.get("presigned_acceptance").get("acceptance_token").asText();
		
		return acceptanceToken;
	}

	@Override
	@SuppressWarnings("null")
	public JsonNode createPaySource(PayMethodDTO payMethodDTO) {

		String fullPath= baseUrl + PAYMENT_SOURCE;
		
		payMethodDTO.setAcceptance_token(getAcceptToken());
		HttpHeaders requestHeaders = new HttpHeaders();		
		requestHeaders.add("Authorization", "Bearer " + privateKey);
		HttpEntity<?> httpEntity = new HttpEntity<Object>(payMethodDTO, requestHeaders);
		JsonNode payMethod = restTemplate.exchange(fullPath, HttpMethod.POST, httpEntity, JsonNode.class).getBody().get("data");
		
        return payMethod;
	}

	@Override
	@SuppressWarnings("null")
	public JsonNode createTransaction(TransactionDTO transactionDTO, User user) {

		String fullPath = baseUrl + CREATE_TRANSACTION;
		HttpHeaders requestHeaders = new HttpHeaders();	
		requestHeaders.add("Authorization", "Bearer " + privateKey);
		String requestJson = "{\"amount_in_cents\": " + transactionDTO.getAmountInPesos() +
                ", \"currency\": \"" + transactionDTO.getCurrency() + "\"" +
                ", \"customer_email\": \"" + user.getEmail() + "\"" +
                ", \"payment_method\": {\"installments\": " + transactionDTO.getInstallments() + "}" +
                ", \"reference\" : \"" + transactionDTO.getReference() + "\"" +
                ", \"payment_source_id\": " + user.getPayMethod().getId() + "}";
		
		HttpEntity<?> httpEntity = new HttpEntity<Object>(requestJson, requestHeaders);
		JsonNode transaction = restTemplate.exchange(fullPath, HttpMethod.POST, httpEntity, JsonNode.class).getBody().get("data");
		
		return transaction;
	}

	@Override
	@SuppressWarnings("null")
	public String statusTransaction(String transactionId) {
		
		String fullPath = baseUrl + STATUS_TRANSACTION;
		String statusTransaction = restTemplate.getForEntity(fullPath, JsonNode.class, transactionId).getBody().get("data")
				.get("status").asText();
		
		return statusTransaction;
	}

}
