package com.payment.rider.driver.dto;

public class PayMethodDTO {
	
	@NotEmpty
	private String type;
	
	@NotEmpty
	private String token;
	
	@NotEmpty
	private String customer_email;
	
	private String acceptance_token;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getAcceptance_token() {
		return acceptance_token;
	}

	public void setAcceptance_token(String acceptance_token) {
		this.acceptance_token = acceptance_token;
	}

	@Override
	public String toString() {
		return "PayMethodDTO [type=" + type + ", token=" + token + ", customer_email=" + customer_email
				+ ", acceptance_token=" + acceptance_token + "]";
	}
	
	

}
