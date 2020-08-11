package com.goshop.service;

import java.util.List;

import com.goshop.dto.UpdateUserDTO;
import com.goshop.model.RoleType;
import com.goshop.model.User;

public interface UserService {

	List<User> getAll();

	User getById(long id);

	User updateUser(User user);

	User createUser(User user);

	void deleteUser(long id);

	List<User> getByRole(RoleType role);

	void paySubscription(long id);

	List<User> getVendorEmployees(long vendorId);

	List<User> getAllVendors();

	List<User> getActivedUsers();

	List<User> getNonActivedUsers();


}
