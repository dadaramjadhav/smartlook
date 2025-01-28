package com.smartlook.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartlook.userservice.exception.UserException;
import com.smartlook.userservice.model.User;
import com.smartlook.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Override
    public User getUserByEmail(String email) throws UserException{
        User user = userRepo.findByEmail(email);
        if(user==null){
            throw new UserException("user not found with email: "+ email);
        }
        return user;
    }

    @Override
    public User getUserById(Long userId) throws UserException  {
        return userRepo.findById(userId).orElseThrow(()-> new UserException("user not found with userid : "+userId ));             
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User addUser(User user) {
        User addedUser = userRepo.save(user);
        return addedUser;
    }
}
