package com.payment.rider.driver.services;

import java.util.List;

import com.payment.rider.driver.entity.User;

public interface IUser {

	public User getUser(Integer userId);
	public List<User> getDriverFree();
	public User save(User user);
}
