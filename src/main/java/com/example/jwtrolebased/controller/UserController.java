package com.example.jwtrolebased.controller;

import com.example.jwtrolebased.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/ping")
    public ResponseEntity<?> ping(){
        return ResponseEntity.ok().body("OK!");
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUser(){
        return ResponseEntity.ok().body(userService.getAll());
    }



}
