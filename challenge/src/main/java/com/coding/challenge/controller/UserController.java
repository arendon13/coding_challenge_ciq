package com.coding.challenge.controller;

import com.coding.challenge.entity.User;
import com.coding.challenge.payload.UserRequest;
import com.coding.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/users", produces={"application/json"})
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping(value="/users/organization", produces={"application/json"})
    public ResponseEntity<List<User>> getUsersInOrganization( @RequestHeader("organizationID") int organizationID ) {

        List<User> users = userService.getUsersInOrganization(organizationID);

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser( @RequestBody UserRequest userRequest ) {

        User user = new User(userRequest);

        userService.addUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}
