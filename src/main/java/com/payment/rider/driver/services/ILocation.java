package com.payment.rider.driver.services;

import com.payment.rider.driver.dto.LocationDTO;
import com.payment.rider.driver.entity.Location;

public interface ILocation {
	public Location saveLocation(LocationDTO locationDTO);
	public Location save(Location location);

}
