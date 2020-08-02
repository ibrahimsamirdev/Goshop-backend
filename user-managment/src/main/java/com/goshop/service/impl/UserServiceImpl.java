package com.goshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goshop.model.User;
import com.goshop.repository.UserRepository;
import com.goshop.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

}
