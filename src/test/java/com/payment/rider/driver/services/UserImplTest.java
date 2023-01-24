package com.payment.rider.driver.services;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.payment.rider.driver.dao.UserDao;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.servicesImpl.UserImpl;


@ExtendWith(MockitoExtension.class)
public class UserImplTest {
	
	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserImpl userImpl;
	
	private User user;
	
	@BeforeEach
	void setUP() {
		user= new User();
		user.setFirstName("John Fredy");
		user.setLastName("Redondo Morelo");
		user.setEmail("relativismofisico@gmail.com");
		user.setStatus("free");
		user.setRole("driver");
		user.setLastService(new Date());
		user.setId(12);
		user.setCreateAt(new Date());
		user.setPhone("3126029259");
	}
	
	@Test
    void getDriverFree()
    {
        when(userDao.findFreeDriver()).thenReturn(Arrays.asList(user));
        assertNotNull(userImpl.getDriverFree());
    }
	
	

}
