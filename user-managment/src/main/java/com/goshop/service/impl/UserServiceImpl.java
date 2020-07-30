package com.goshop.service.impl;

import com.goshop.model.User;
import com.goshop.repository.UserRepository;
import com.goshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;


}
