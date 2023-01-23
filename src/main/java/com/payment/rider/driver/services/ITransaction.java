package com.payment.rider.driver.services;

import com.payment.rider.driver.dto.TransactionDTO;
import com.payment.rider.driver.entity.PayMethod;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.entity.Transaction;

public interface ITransaction {
	public Transaction saveTransaction(TransactionDTO transactionDTO, String information, Rider rider, PayMethod payMethos);
	public Transaction save(Transaction transaction);
}
