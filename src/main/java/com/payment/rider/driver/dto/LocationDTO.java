package com.payment.rider.driver.dto;

import javax.validation.constraints.NotEmpty;

public class LocationDTO {
	
	@NotEmpty
	private String latitude;
	
	@NotEmpty
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "LocationDTO [latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	

}
