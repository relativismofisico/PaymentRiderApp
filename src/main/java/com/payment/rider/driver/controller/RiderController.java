package com.payment.rider.driver.controller;

import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.payment.rider.driver.dao.LocationDao;
import com.payment.rider.driver.dto.LocationDTO;
import com.payment.rider.driver.dto.TransactionDTO;
import com.payment.rider.driver.entity.Location;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.entity.Transaction;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.ILocation;
import com.payment.rider.driver.services.IPaymentGateway;
import com.payment.rider.driver.services.IRider;
import com.payment.rider.driver.services.ITransaction;
import com.payment.rider.driver.servicesImpl.PaymentGatewayImpl;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api/versionDemo")
public class RiderController {
	
	@Autowired
	private ILocation iLocation;
	
	@Autowired
	private IRider iRider;
	
	@Autowired
	private IPaymentGateway iPaymentGateway;
	
	@Autowired
	private ITransaction iTransaction;
	
	@Autowired
	private TransactionDTO transactionDto;
	
	@PostMapping(value="/rider/start/{userId}")
	public String startRider(@Valid @RequestBody LocationDTO location, BindingResult result, @PathVariable Integer userId) {
		
		Location localCreated= null;
		String response="";
		
		try {
			
			localCreated= iLocation.saveLocation(location);
			Rider rider=iRider.startRider(userId, localCreated);
			
			if(rider.equals(null)) {
				throw new RuntimeException("Rider No Start");
			}
			response="Rider is " + rider.getId();
			
		} catch (Exception e) {
			response=e.getMessage();
		}
		
		return response;
		
	}
	
	@PutMapping(value="/rider/end/{userId]/{riderId}")
	public String endRider(@PathVariable Integer userId, @PathVariable Integer riderId, @RequestBody Map<String, String> data) {
		
		String response= "";
		
		try {
			
			Integer distanceTraveledKm = Integer.valueOf(data.get("km"));
			Integer time = Integer.valueOf(data.get("minutes"));
			Integer installments = Integer.valueOf(data.get("installments"));
			String reference= data.get("reference");
			
			if(reference.equals("")) {
				throw new RuntimeException("We need a reference.....");
			}
			
			transactionDto.setAmountInPesos(distanceTraveledKm, time);
			transactionDto.setReference(reference);
			transactionDto.setInstallments(installments);
			transactionDto.setCurrency("COP");
			
			User user = iRider.endRider(userId, riderId);
			
			JsonNode transaction = iPaymentGateway.createTransaction(transactionDto, user);
			
			Transaction transactionCreated= iTransaction.saveTransaction(transactionDto, transaction.get("id").asText()
					, user.getRide(),user.getPayMethod());
			
			if(transactionCreated.equals(null)) {
				throw new RuntimeException("Try Again.....");
			}
			
			response = "La transaction is: " + transactionCreated.getId();
			
		} catch (Exception e) {
			response= e.getMessage();
		}
		
		return response;
	}
	
	
	

}
