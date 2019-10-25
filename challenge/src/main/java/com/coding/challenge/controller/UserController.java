package com.coding.challenge.controller;

import com.coding.challenge.entity.User;
import com.coding.challenge.entity.UserOrganization;
import com.coding.challenge.payload.UserRequest;
import com.coding.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value="/user/organization/{organizationID}", produces={"application/json"})
    public ResponseEntity<List<User>> getUsersInOrganization( @PathVariable("organizationID") int organizationID ) {

        List<User> users = userService.getUsersInOrganization(organizationID);

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser( @RequestBody UserRequest userRequest ) {

        User user = new User(userRequest);

        userService.addUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping("/user/{userID}/organization/{organizationID}")
    public ResponseEntity<?> addUserToOrganization(
            @PathVariable("userID") int userID,
            @PathVariable("organizationID") int organizationID)
    {

        UserOrganization userOrganization = new UserOrganization(userID, organizationID);

        HttpStatus response = userService.addUserToOrganization(userOrganization) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(response);

    }

    @DeleteMapping("/user/{userID}/organization/{organizationID}")
    public ResponseEntity<?> removeUserFromOrganization(
            @PathVariable("userID") int userID,
            @PathVariable("organizationID") int organizationID)
    {

        UserOrganization userOrganization = new UserOrganization(userID, organizationID);

        HttpStatus response = userService.removeUserFromOrganization(userOrganization) ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(response);

    }



}
