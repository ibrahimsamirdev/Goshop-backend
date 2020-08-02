package com.goshop.service;

import java.util.List;

import com.goshop.model.RoleType;
import com.goshop.model.User;

public interface UserService {

	List<User> getAll();

	User getById(long id);

	void updateUser(User user);

	List<User> getByRole(RoleType role);

}
