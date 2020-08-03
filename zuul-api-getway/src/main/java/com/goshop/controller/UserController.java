package com.goshop.controller;


import com.goshop.exception.CustomException;
import com.goshop.model.Role;
import com.goshop.model.RoleType;
import com.goshop.model.User;
import com.goshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin("*")
    @PostMapping("/signin")
//    @ResponseBody
    public ResponseEntity<Object> login(@RequestParam("email") String email, @RequestParam("password") String password) {

            String token = userService.login(email, password);
//            HttpHeaders headers = new HttpHeaders();
//            List<String> headerlist = new ArrayList<>();
//            List<String> exposeList = new ArrayList<>();
//            headerlist.add("Content-Type");
//            headerlist.add(" Accept");
//            headerlist.add("X-Requested-With");
//            headerlist.add("Authorization");
//            headers.setAccessControlAllowHeaders(headerlist);
//            exposeList.add("Authorization");
//            headers.setAccessControlExposeHeaders(exposeList);
//            headers.set("Authorization", token);
            return new ResponseEntity<Object>(token, HttpStatus.CREATED);


    }

    @CrossOrigin("*")
    @PostMapping("/register")
//    @ResponseBody
    public ResponseEntity<Object> signout(@RequestBody User user) {
        User u = userService.saveUser(user,RoleType.registeredUser);
        return new ResponseEntity<Object>("success", HttpStatus.CREATED);
    }


}