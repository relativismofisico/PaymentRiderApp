package com.payment.rider.driver.services;

import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.theInstance;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.payment.rider.driver.dao.RiderDao;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.servicesImpl.RiderImpl;
import com.payment.rider.driver.servicesImpl.UserImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)	
public class RiderImplTest {
	
	@Mock
	private UserImpl userImpl;
	
	@Mock
	private RiderDao riderDao;
	
	@Mock
	private RiderImpl riderMock;
	
	@InjectMocks
	private RiderImpl rideImpl;
	private User userRider;
	private User userDriver;
	private Rider rider;
	
	@BeforeEach
	void setUp(){
		List<User> users = new ArrayList<>();
		
		userRider = new User();
		userRider.setFirstName("Juan");
		userRider.setLastName("Lopez");
		userRider.setEmail("juan.lopez@gmail.com");
		userRider.setStatus("init_ride");
		userRider.setRole("rider");
		userRider.setCreateAt(new Date());
		userRider.setPhone("32065823128");
        
		userDriver  = new User();
		userDriver.setFirstName("Sebastian");
		userDriver.setLastName("Orrgeo");
		userDriver.setEmail("sebastian.orrego@gmail.com");
		userDriver.setStatus("free");
		userDriver.setRole("driver");
		userDriver.setLastService(new Date());
		userDriver.setCreateAt(new Date());
		userDriver.setPhone("3192306265");
		
		users.add(userRider);
		users.add(userDriver);
		
		rider=new Rider();
		rider.setStatus("init");
		rider.setCreateAt(new Date());
		rider.setUser(users);
		
	}

	@SuppressWarnings("unchecked")
    @Test
    void findUserFree() {
        when(userImpl.getDriverFree()).thenReturn(Arrays.asList(userDriver));
        assertNotNull(rideImpl.findUserFree());
    }
}
