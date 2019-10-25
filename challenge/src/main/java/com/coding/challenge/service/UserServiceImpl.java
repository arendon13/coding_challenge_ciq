package com.coding.challenge.service;

import com.coding.challenge.entity.User;
import com.coding.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach( users::add );

        return users;

    }

    @Override
    public List<User> getUsersInOrganization(int id) {

        return userRepository.fetchUsersInOrganization(id);

    }

    @Override
    public void addUser(User user) {

        userRepository.save(user);

    }
}
