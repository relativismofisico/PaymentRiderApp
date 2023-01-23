package com.payment.rider.driver.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.rider.driver.entity.Transaction;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, String>{

}
