package com.payment.rider.driver.dto;

public class TransactionDTO {

	private static final double PRICE_KM= 1000.0;
	private static final double PRICE_MINUTE=200.0;
	private static final double PRICE_BASE=3500.0;
	
	private Double amountInPesos;
	private String currency;
	private String reference;
	private Integer installments;
	private Integer paymentSourceId;
	
	
	public Double getAmountInPesos() {
		return amountInPesos;
	}
	public void setAmountInPesos(double km, double time) {
		this.amountInPesos = (PRICE_BASE + (PRICE_KM * km) + (PRICE_MINUTE * time));
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public Integer getPaymentSourceId() {
		return paymentSourceId;
	}
	public void setPaymentSourceId(Integer paymentSourceId) {
		this.paymentSourceId = paymentSourceId;
	}
	
	
}
