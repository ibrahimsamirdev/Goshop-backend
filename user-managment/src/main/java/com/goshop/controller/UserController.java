package com.goshop.controller;

import java.util.List;

import com.goshop.dto.UpdateUserDTO;
import com.goshop.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<Object> updateUser(@RequestBody UpdateUserDTO user) {
		userService.updateUser(user);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}

	/**
	 * Create User with any role
	 *
	 * @param user - the user to be created
	 * @return string "success"
	 */
	@PostMapping()
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<Object>("success", HttpStatus.CREATED);
	}

	/**
	 * register User with registeredUser role
	 *
	 * @param user - the user to be created
	 * @return string "success"
	 */
	@PostMapping("/register")
	public ResponseEntity<Object> signout(@RequestBody User user) {
		Role r = new Role();
		r.setRole(RoleType.registeredUser);
		user.setRole(r);
		User u = userService.createUser(user);
		return new ResponseEntity<Object>("success", HttpStatus.CREATED);
	}

	/**
	 * Delete User by id
	 *
	 * @param id - the id for the user
	 * @return string "user deleted successfully"
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Object>("user deleted successfully", HttpStatus.OK);
	}

	/**
	 * Pay User (vendor) subscription
	 * 
	 * @param id - user id
	 * @return string "success"
	 */
	@PutMapping("/pay/{id}")
	public ResponseEntity<Object> paySubscription(@PathVariable long id) {
		userService.paySubscription(id);
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}

}
