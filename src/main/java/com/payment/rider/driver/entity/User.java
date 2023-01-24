package com.payment.rider.driver.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import jakarta.persistence.JoinColumn;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Table(name="users")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer Id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String role;
	private String status;
	
	@Column(name="last_service")
	private Date lastService;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pay_methos_id", referencedColumnName = "id")
	private PayMethod payMethod;
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="update_at")
	private Date updateAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Rider ride;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastService() {
		return lastService;
	}

	public void setLastService(Date lastService) {
		this.lastService = lastService;
	}

	public PayMethod getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
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

	public Rider getRide() {
		return ride;
	}

	public void setRide(Rider ride) {
		this.ride = ride;
	}
	
	private static final long serialVersionUID = 1L;
		
}
