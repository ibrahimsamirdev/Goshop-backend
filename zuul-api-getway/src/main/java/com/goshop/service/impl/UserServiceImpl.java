package com.goshop.service.impl;

import com.goshop.Security.JwtTokenProvider;
import com.goshop.exception.CustomException;
import com.goshop.model.Role;
import com.goshop.model.RoleType;
import com.goshop.model.User;
import com.goshop.repository.UserRepository;
import com.goshop.service.RoleService;
import com.goshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null || user.getRole() ==null){
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }

        // if user hase many roles
//        String [] authorities = new String[user.getRole().size()];
//        int count=0;
//        for (Role role : user.getRole()) {
//            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
//            //Since we are using custom token using JWT we should add ROLE_ prefix
//            authorities[count] = "ROLE_"+role.getRole();
//            count++;
//        }
        String authority = "ROLE_"+user.getRole();

        return org.springframework.security.core.userdetails.User//
                .withUsername(email)//
                .password(user.getPass())//
                .authorities(authority)//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();

    }




    @Override
    public String login(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                    password));
            User user = userRepository.findByEmail(username);
            if (user == null || user.getRole() == null) {
                throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
            }
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
//            String token =  jwtTokenProvider.createToken(username, user.getRole().stream()
//                    .map((Role role)-> "ROLE_"+role.getRole()).filter(Objects::nonNull).collect(Collectors.toList()));
            List<String> roles = new ArrayList<>();
            roles.add(user.getRole().toString());
            String token =  jwtTokenProvider.createToken(username, roles);
            return token;

        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public User saveUser(User user, RoleType roleType) {
        user.setRole(roleService.getRoleByType(roleType));
        user.setPass(passwordEncoder.encode(user.getPass()) );
        return userRepository.save(user);
    }



    @Override
    public Boolean isValidToken(String token) {
        return jwtTokenProvider.validateToken(token);
    }

    @Override
    public String createNewToken(String token) {
        String username = jwtTokenProvider.getUsername(token);
        List<String>roleList = jwtTokenProvider.getRoleList(token);
        String newToken =  jwtTokenProvider.createToken(username,roleList);
        return newToken;
    }
}
