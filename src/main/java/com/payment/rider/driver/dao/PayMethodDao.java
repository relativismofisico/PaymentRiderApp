package com.payment.rider.driver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.rider.driver.entity.PayMethod;

@Repository
public interface PayMethodDao extends CrudRepository<PayMethod, Integer>{

}
