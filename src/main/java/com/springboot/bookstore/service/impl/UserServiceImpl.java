package com.springboot.bookstore.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.bookstore.entity.User;
import com.springboot.bookstore.repository.UserRepository;
import com.springboot.bookstore.service.UserService;

@Service 
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User User) {
		return userRepository.save(User);
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User User) {
		return userRepository.save(User);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}
	
}
