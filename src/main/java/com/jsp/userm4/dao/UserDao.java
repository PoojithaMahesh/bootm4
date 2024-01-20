package com.jsp.userm4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userm4.dto.User;
import com.jsp.userm4.repo.UserRepo;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	
	public void saveUser(User user) {
	repo.save(user);
	}

	
}
