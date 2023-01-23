package com.payment.rider.driver.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.rider.driver.dao.PayMethodDao;
import com.payment.rider.driver.dto.PayMethodDTO;
import com.payment.rider.driver.entity.PayMethod;
import com.payment.rider.driver.entity.User;
import com.payment.rider.driver.services.IPayMethods;
import com.payment.rider.driver.services.IUser;

@Service
public class PayMethodImpl implements IPayMethods{

	@Autowired
	private PayMethodDao payMethodDao;
	
	@Autowired
	private IUser iUser;
	
	@Autowired
	private PayMethod payMethod;
	
	@Override
	public PayMethod getPayMethod(Integer payMethodId) {
		return payMethodDao.findById(payMethodId).orElse(null);
	}

	@Override
	public PayMethod savePayMethod(PayMethodDTO payMethodDTO, Integer idPayMethod, String status, User user) {
		
		payMethod.setCustomerEmail(payMethodDTO.getCustomer_email());
		payMethod.setToken(payMethodDTO.getToken());
		payMethod.setType(payMethodDTO.getType());
		payMethod.setId(idPayMethod);
		payMethod.setStatus(status);
		save(payMethod);
		
		user.setPayMethod(payMethod);
		iUser.save(user);
		
		return payMethod;
	}

	@Override
	public PayMethod save(PayMethod payMethod) {
		return payMethodDao.save(payMethod);
	}

}
