package com.jsp.userm4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.userm4.dao.UserDao;
import com.jsp.userm4.dto.User;
import com.jsp.userm4.exception.UserIdNotFoundException;
import com.jsp.userm4.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;


	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbUser=dao.saveUser(user);
		ResponseStructure<User> structure=new ResponseStructure<>();
		structure.setMessage("User Data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbUser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}


	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser=dao.findUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}else {
			throw new UserIdNotFoundException("Sorry failed to fetch the data");
		}	
	}


	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User dbUser=dao.deleteUser(id);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User Data Deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}else {
			throw new UserIdNotFoundException("Sorry failed to delete the data");
		}	
	}


	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User dbUser=dao.updateUser(id,user);
		if(dbUser!=null) {
//			id is present
			ResponseStructure<User> structure=new ResponseStructure<>();
			structure.setMessage("User Data updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}else {
			throw new UserIdNotFoundException("Sorry failed to update the data");
		}	
	}


	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> list=dao.findAllUser();
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		structure.setMessage("User Data  found");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
	}

	
	
	
	
	
}
