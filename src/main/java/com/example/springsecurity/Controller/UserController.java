package com.example.springsecurity.Controller;

import com.example.springsecurity.Service.MyUserDetailsService;
import com.example.springsecurity.Service.UserService;
import com.example.springsecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    UserService service;

    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @PostMapping("/user")
    public Users addUsers(@RequestBody Users user){
        return service.register(user);
    }

}
