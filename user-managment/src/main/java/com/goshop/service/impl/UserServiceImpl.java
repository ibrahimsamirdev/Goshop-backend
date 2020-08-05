package com.goshop.service.impl;

import java.util.List;
import java.util.Optional;

import com.goshop.dto.UpdateUserDTO;
import com.goshop.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	RoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User getById(long id) {
		return userRepo.findById(id).orElseThrow(() -> new CustomException("User Not Found", HttpStatus.NOT_FOUND));
	}

	@Override
	public void updateUser(UpdateUserDTO userDTO) {
//		if (!userRepo.existsById(userDTO.getId())) {
//			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
//		}

		Optional<User> userOptional = userRepo.findById(userDTO.getId());
		if(!userOptional.isPresent()){
			throw new CustomException("User Doesn't Exist", HttpStatus.NOT_FOUND);
		}
		boolean isPasswordMatch = passwordEncoder.matches(userDTO.getPass(), userOptional.get().getPass());
		if(!isPasswordMatch){
			throw new CustomException("Old password is wrong", HttpStatus.NOT_ACCEPTABLE);
		}

		User user = modelMapper.map(userDTO, User.class);
		user.setPass(passwordEncoder.encode(userDTO.getNewPass()));
		userRepo.save(user);
	}

	@Override
	public User createUser(User user) {
		user.setRole(roleService.getRoleByType(user.getRole().getRole()));
		user.setPass(passwordEncoder.encode(user.getPass()));
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

	@Override
	public void paySubscription(long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new CustomException("User Not Found", HttpStatus.NOT_FOUND));
		if (user.getSubscribed()) {
			throw new CustomException("User already subscriped", HttpStatus.NOT_ACCEPTABLE);
		}
		user.setSubscribed(true);
		userRepo.save(user);
	}

}
