package com.smartlook.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String welcome(){
        return "welcome to smartlook...";
    }

    @RequestMapping("/home")
    public String home(){
        return "this is home page";
    } 
}
