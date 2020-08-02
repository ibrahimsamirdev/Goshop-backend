package com.goshop.service;

import java.util.List;

import com.goshop.model.User;

public interface UserService {

	List<User> getAll();

	User getById(long id);

}
