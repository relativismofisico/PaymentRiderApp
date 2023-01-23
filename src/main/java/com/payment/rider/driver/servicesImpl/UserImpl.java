package com.payment.rider.driver.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.rider.driver.dao.UserDao;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.IUser;

@Service
public class UserImpl implements IUser{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(Integer userId) {
		return userDao.findById(userId).orElse(null);
	}

	@Override
	public List<User> getDriverFree() {
		List<User> driverFree=userDao.findFreeDriver();
		return driverFree;
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

}
