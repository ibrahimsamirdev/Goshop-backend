package com.goshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goshop.model.User;
import com.goshop.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String test() {
		return "UserManagement Microservices is running";
	}

	/**
	 * Get all users
	 * 
	 * @return User Object
	 */
	@GetMapping("/")
	public ResponseEntity<Object> getAllUsers() {
		List<User> users = userService.getAll();
		return new ResponseEntity<Object>(users, HttpStatus.CREATED);
	}

}
