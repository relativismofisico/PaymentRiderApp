package com.payment.rider.driver.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.payment.rider.driver.dto.PayMethodDTO;
import com.payment.rider.driver.dto.TransactionDTO;
import com.payment.rider.driver.entity.PayMethod;
import com.payment.rider.driver.entity.User;

public interface IPaymentGateway {
	
	public String getAcceptToken();
	public JsonNode createPaySource(PayMethodDTO payMethodDTO);
	public JsonNode createTransaction(TransactionDTO transactionDTO, User user);
	public String statusTransaction(String transactionId);
	

}
