package com.payment.rider.driver.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	private String Id;
	
	@Column(name="amount_in_cents")
	private Integer amountInCents;
	
	private String currency;
	private String reference;
	private Integer installments;
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="update_At")
	private Date updateAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ride_id", referencedColumnName = "id")
	private Rider rider;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pay_method_id", referencedColumnName = "id")
	private PayMethod payMethod;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Integer getAmountInCents() {
		return amountInCents;
	}

	public void setAmountInCents(Integer amountInCents) {
		this.amountInCents = amountInCents;
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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Rider getRider() {
		return rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

	public PayMethod getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}
	
	@PrePersist
	public void prePersist() {
		createAt= new Date();
	}
}
