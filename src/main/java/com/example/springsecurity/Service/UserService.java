package com.example.springsecurity.Service;

import com.example.springsecurity.Repository.UserRepo;
import com.example.springsecurity.jwt.JwtService;
import com.example.springsecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    public Users register(Users users){
        return repo.save(users);
    }


    public String verify(Users user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generatetoken(user.getUsername());
        }
        else{
            return "Not Found!";
        }
    }
}
