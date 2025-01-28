package com.smartlook.userservice.service;

import java.util.List;

import com.smartlook.userservice.exception.UserException;
import com.smartlook.userservice.model.User;

public interface UserService {
    public User getUserByEmail(String email) throws UserException;
    public User getUserById(Long userId) throws UserException;
    public List<User> getAllUsers();
    public User addUser(User user);

}
