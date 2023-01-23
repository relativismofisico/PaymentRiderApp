package com.payment.rider.driver.services;

import com.payment.rider.driver.entity.Location;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.entity.User;

public interface IRider {
	public Rider startRider(Integer userId, Location location);
	public Rider saveRider(Rider rider);
	public User endRider(Integer userId, Integer riderId);
	public User findUserFree();

}
