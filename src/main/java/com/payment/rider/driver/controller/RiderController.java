package com.payment.rider.driver.controller;

import javax.management.RuntimeErrorException;
import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.rider.driver.dao.LocationDao;
import com.payment.rider.driver.dto.LocationDTO;
import com.payment.rider.driver.entity.Location;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.services.ILocation;
import com.payment.rider.driver.services.IPaymentGateway;
import com.payment.rider.driver.services.IRider;
import com.payment.rider.driver.services.ITransaction;

@RestController
@RequestMapping("api/versionDemo/")
public class RiderController {
	
	@Autowired
	private ILocation iLocation;
	
	@Autowired
	private IRider iRider;
	
	@Autowired
	private IPaymentGateway iPaymentGateway;
	
	@Autowired
	private ITransaction iTransaction;
	
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
	
	
	

}
