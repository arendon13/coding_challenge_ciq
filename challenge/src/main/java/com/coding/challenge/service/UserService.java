package com.coding.challenge.service;

import com.coding.challenge.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    List<User> getUsersInOrganization(int id);

    void addUser(User user);

}
