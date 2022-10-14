package com.williansmartins.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String getUsers(){
        return "Retorno do metodo getUser - HTTP GET";
    }
 
    @PostMapping
    public String createUser(){
        return "Retorno do metodo createUser - HTTP POST";
    }
 
    @PutMapping
    public String updateUser(){
        return "Retorno do metodo updateUser - HTTP PUT";
    }
 
    @DeleteMapping
    public String deleteUser(){
        return "Retorno do metodo deleteUser - HTTP DELETE";
    }
}