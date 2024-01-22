package com.jsp.userm4.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.userm4.dto.User;
import com.jsp.userm4.repo.UserRepo;

import jakarta.persistence.EntityManagerFactory;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findUser(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			return user;
		}
		return null;
	}

	public User deleteUser(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
            repo.delete(user);
           return user;
		}
		return null;
	}

	public User updateUser(int id, User user) {
		Optional<User> optional=repo.findById(id);
		if(optional.isPresent()) {
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
