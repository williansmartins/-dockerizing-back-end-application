package com.williansmartins.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUsers(){
        return "HTTP GET";
    }
 
    @PostMapping
    public String createUser(){
        return "HTTP POST";
    }
 
    @PutMapping
    public String updateUser(){
        return "HTTP PUT";
    }
 
    @DeleteMapping
    public String deleteUser(){
        return "HTTP DELETE";
    }
}