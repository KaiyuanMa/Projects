package com.example.demo.controller;

import com.example.demo.model.user;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class userController {

    @Autowired
    private userService userService;
    
    @PostMapping("/signup")
    public user signup(@RequestBody user user) {
        return userService.signup(user);
    }

    @GetMapping("/getUserById/{id}")
    public user findUserById (@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/getUserByEmail/{email}")
    public user findUserByEmail (@PathVariable String email) {
        return userService.findByEmail(email);
    }

}