package com.example.demo.service;

import com.example.demo.model.user;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userRepository repository;

    public user signup(user user) {
        return repository.save(user);
    }

    public user findById(int id){
        return repository.findById(id).orElse(null);
    }

    public user findByEmail(String email) {
        return repository.findByEmail(email);
    }
}