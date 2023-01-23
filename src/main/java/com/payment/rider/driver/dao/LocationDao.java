package com.payment.rider.driver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.rider.driver.entity.Location;

@Repository
public interface LocationDao extends CrudRepository<Location, Integer> {

}
