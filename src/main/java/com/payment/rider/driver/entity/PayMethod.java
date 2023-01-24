package com.payment.rider.driver.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
@Table(name="pay_methods")
public class PayMethod implements Serializable{
	
	@Id
	private Integer Id;
	
	private String type;
	private String token;
	private String status;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="update_at")
	private Date updateAt;
	
	@OneToOne(mappedBy="payMethod")
	private User user;
	
	@OneToOne(mappedBy="payMethod")
	private Transaction transaction;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	@PrePersist
	public void prePersist() {
		createAt= new Date();
	}
	
	private static final long serialVersionUID = 1L;

	
}
