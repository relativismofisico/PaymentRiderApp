package com.payment.rider.driver.servicesImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.rider.driver.dao.RiderDao;
import com.payment.rider.driver.entity.Location;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.IRider;
import com.payment.rider.driver.services.IUser;

@Service
public class RiderImpl implements IRider{

	@Autowired
	private RiderDao riderDao;
	
	@Autowired
	private IUser iUser;
	
	@Autowired
	private Rider ride;
	
	
	@Override
	public Rider startRider(Integer userId, Location location) {
		
		List<User> users= new ArrayList<>();
		
		User rider=iUser.getUser(userId);
		User driver= this.findUserFree();
		
		if(rider.equals(null)) {
			throw new RuntimeException("User: " + userId + " doesn´t Exist");
		}
		
		if(driver.equals(null)) {
			throw new RuntimeException("Drivers don't availables");
		}
		
		if(rider.getStatus().equals("init_ride")){
			throw new RuntimeException("User Exist");
		}
		
		users.add(rider);
		users.add(driver);
		
		ride.setLocation(location);
		ride.setStatus("Start");
		ride.setUser(users);
		saveRider(ride);
		
		rider.setRide(ride);
		rider.setStatus("init_ride");
		driver.setRide(ride);
		driver.setLastService(new Date());
		driver.setStatus("busy");
		iUser.save(rider);
		iUser.save(driver);
		
		return ride;
	}

	@Override
	public Rider saveRider(Rider rider) {
		return riderDao.save(rider);
	}

	@Override
	public User endRider(Integer userId, Integer riderId) {
		
		Rider ride=riderDao.findById(riderId).orElse(null);
		User rider=null;
		
		if(ride==null) {
			throw new RuntimeException("Trip doesn't  Exist");
		}
		if(ride.getStatus().equals("finished")) {
			throw new RuntimeException("Trip was done");
		}
		for(User user:ride.getUser()) {
			if(user.getId()==userId) {
				if(user.getRole().equals("driver")) {
					ride.setStatus("finished");
					ride.setUpdateAt(new Date());
					this.saveRider(ride);
					
					user.setStatus("free");
					iUser.save(user);
				}
			}
			if(user.getRole().equals("rider")) {
				user.setStatus("finished_ride");
				rider=user;
				iUser.save(user);
			}
		}
		
		return rider;
	}

	@Override
	public User findUserFree() {
		
		User user=null;
		List<User> users=iUser.getDriverFree();

		if(users.size()!=0) {
			user=users.get(0);
		}
		
		return user;
	}

	
}
