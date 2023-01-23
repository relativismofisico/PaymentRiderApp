package com.payment.rider.driver.services;

import com.payment.rider.driver.dto.PayMethodDTO;
import com.payment.rider.driver.entity.PayMethod;
import com.payment.rider.driver.entity.User;

public interface IPayMethods {
	
	public PayMethod getPayMethod(Integer payMethodId);
	public PayMethod savePayMethod(PayMethodDTO payMethodDTO, Integer idPayMethod, String status, User user);
	public PayMethod save(PayMethod payMethod);

}
