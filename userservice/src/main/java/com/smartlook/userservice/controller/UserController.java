package com.smartlook.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlook.userservice.dto.UserDto;
import com.smartlook.userservice.exception.UserException;
import com.smartlook.userservice.mapper.UserMapper;
import com.smartlook.userservice.model.User;
import com.smartlook.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user) throws UserException{
        User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) throws UserException{
        User user = userService.getUserById(id);
        UserDto userDto = userMapper.mapUserToUserDto(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() throws UserException{
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
