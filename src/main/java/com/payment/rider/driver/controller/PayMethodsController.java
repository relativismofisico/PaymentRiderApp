package com.payment.rider.driver.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.payment.rider.driver.dao.PayMethodDao;
import com.payment.rider.driver.dto.PayMethodDTO;
import com.payment.rider.driver.entity.PayMethod;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.IPayMethods;
import com.payment.rider.driver.services.IPaymentGateway;
import com.payment.rider.driver.services.IUser;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api/pays")
public class PayMethodsController {

	@Autowired
	private IPaymentGateway iPaymentGateway;
	
	@Autowired
	private IUser iUser;
	
	@Autowired
	private IPayMethods iPayMethods;
	
	@GetMapping("/Status/transaction/{transactionId}")
	public String getStatusTransaction(@PathVariable String transactionId){
		
		String statusTransaction = iPaymentGateway.statusTransaction(transactionId);
		
		return "The transaction is: " + statusTransaction;
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/{userId}")
	public String createdPayMethod(@Valid @RequestBody PayMethodDTO payMethodDto, BindingResult result, @PathVariable Integer userId) {
		
		String response= "";
		
		User user=null;
		
		try {
			if(result.hasErrors()) {
				throw new RuntimeException("There is some Error.........Try again");
			}
			
			user=iUser.getUser(userId);
			
			if(user.equals(null)) {
				throw new RuntimeException("User doesn't exist.........Try again");

			}
			
			if(!user.getRole().equals("rider")) {
				throw new RuntimeException("User isn't a Rider.........Try again");
			}
			
			JsonNode payMethodDTOCreated = iPaymentGateway.createPaySource(payMethodDto);
			PayMethod payMethod = iPayMethods.savePayMethod(payMethodDto, payMethodDTOCreated.get("id").asInt()
					, payMethodDTOCreated.get("status").asText(), user);
		
			response = "Number's Pay is: " + payMethodDTOCreated.get("id").asText();
			
		} catch (Exception e) {
			response= e.getMessage();
		}
		
		return response;
		
		
	}
	
}
