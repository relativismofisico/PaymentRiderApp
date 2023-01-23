package com.payment.rider.driver.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.rider.driver.dao.LocationDao;
import com.payment.rider.driver.dto.LocationDTO;
import com.payment.rider.driver.entity.Location;
import com.payment.rider.driver.services.ILocation;

@Service
public class LocationImpl implements ILocation{
	
	@Autowired
	private LocationDao locationDao;

	@Autowired
	private Location locationCreated;
	
	@Override
	public Location saveLocation(LocationDTO locationDTO) {
			
		try {
			locationCreated.setLatitude(locationDTO.getLatitude());
			locationCreated.setLongitude(locationDTO.getLongitude());
			this.save(locationCreated);
		} catch (Exception e) {
			locationCreated=null;
		}
		return locationCreated;
	}

	@Override
	public Location save(Location location) {
		return locationDao.save(location);
	}
	
	
}
