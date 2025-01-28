package com.smartlook.userservice.apprunners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.smartlook.userservice.model.User;
import com.smartlook.userservice.service.UserService;
@Component
public class LoadData implements ApplicationRunner{

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addUser(new User("dm1", "dmj1", "dm1@gmail.com", "901101"));
        userService.addUser(new User("dm2", "dmj2", "dm2@gmail.com", "901102"));
        userService.addUser(new User("dm3", "dmj3", "dm3@gmail.com", "901103"));
        userService.addUser(new User("dm4", "dmj4", "dm4@gmail.com", "901104"));
        userService.addUser(new User("dm5", "dmj5", "dm5@gmail.com", "901105"));        
    }
}
