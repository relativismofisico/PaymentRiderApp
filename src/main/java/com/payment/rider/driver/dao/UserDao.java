package com.payment.rider.driver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.rider.driver.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.role='driver' and u.status='free'")
	public List<User> findFreeDriver();
	
}
