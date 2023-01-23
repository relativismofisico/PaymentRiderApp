package com.payment.rider.driver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.rider.driver.entity.Rider;

@Repository
public interface RiderDao extends CrudRepository<Rider, Integer>{

}
