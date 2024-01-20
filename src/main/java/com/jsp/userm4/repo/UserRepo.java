package com.jsp.userm4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.userm4.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	

}
