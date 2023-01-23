package com.payment.rider.driver.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.rider.driver.dao.TransactionDao;
import com.payment.rider.driver.dto.TransactionDTO;
import com.payment.rider.driver.entity.PayMethod;
import com.payment.rider.driver.entity.Rider;
import com.payment.rider.driver.entity.Transaction;
import com.payment.rider.driver.services.ITransaction;



@Service
public class TransactionImpl implements ITransaction{
	
    @Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private Transaction transaction;

	@Override
	public Transaction saveTransaction(TransactionDTO transactionDTO, String transactionId, Rider rider,
			PayMethod payMethod) {
		
		transaction.setId(transactionId);
		transaction.setReference(transactionDTO.getReference());
		transaction.setAmountInPesos(transactionDTO.getAmountInPesos());
		transaction.setCurrency(transactionDTO.getCurrency());
		transaction.setInstallments(transactionDTO.getInstallments());
		transaction.setRider(rider);
		transaction.setPayMethod(payMethod);
			
		return transaction;
	}

	@Override
	public Transaction save(Transaction transaction) {

		return transactionDao.save(transaction);
	}

}
