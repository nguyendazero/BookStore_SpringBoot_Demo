package com.springboot.bookstore.service;

import java.util.List;

import com.springboot.bookstore.entity.User;

public interface UserService {

	List<User> getAllUsers();
	
	User saveUser(User User);
	
	User getUserById(int id);
	
	User updateUser(User User);
	
	void deleteUser(int id);
	
	User getUserByUsernameAndPass(String userName, String password);
	
}
