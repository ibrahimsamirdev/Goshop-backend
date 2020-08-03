package com.goshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.goshop.model.RoleType;
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
	 * @return List of User objects
	 */
	@GetMapping()
	public ResponseEntity<Object> getAllUsers() {
		List<User> users = userService.getAll();
		return new ResponseEntity<Object>(users, HttpStatus.OK);
	}

	/**
	 * Get User by Id
	 * 
	 * @param id - user id
	 * @return User object
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable long id) {
		User user = userService.getById(id);
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	/**
	 * Get all Users by user role (all vendors, contentCreators,...)
	 * 
	 * @param role - RoleType (enum) user role
	 * @return List of All User objects with a specific role
	 */
	@GetMapping("/role/{role}")
	public ResponseEntity<Object> getUsersByRole(@PathVariable RoleType role) {
		List<User> users = userService.getByRole(role);
		return new ResponseEntity<Object>(users, HttpStatus.OK);
	}

	/**
	 * Update User
	 * 
	 * @param user - the user to be updated
	 * @return string "success"
	 */
	@PutMapping()
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Object>("user deleted successfully", HttpStatus.OK);
	}

}
