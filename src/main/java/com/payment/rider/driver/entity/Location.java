package com.payment.rider.driver.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="update_at")
	private Date updateAt;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ride_id", referencedColumnName = "id")
	private Rider rider;
}
