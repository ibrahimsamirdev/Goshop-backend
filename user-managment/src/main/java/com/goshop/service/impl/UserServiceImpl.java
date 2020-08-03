package com.goshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.goshop.exception.CustomException;
import com.goshop.model.RoleType;
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

	@Override
	public User getById(long id) {
		return userRepo.findById(id).orElseThrow(() -> new CustomException("User Not Found", HttpStatus.NOT_FOUND));
	}

	@Override
	public void updateUser(User user) {
		if (!userRepo.existsById(user.getId())) {
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		userRepo.save(user);
	}

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}

	@Override
	public List<User> getByRole(RoleType role) {
		return userRepo.findByRole(role);
	}

}
