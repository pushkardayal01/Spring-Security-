package com.example.springsecurity.Service;

import com.example.springsecurity.Repository.UserRepo;
import com.example.springsecurity.model.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepo repo;

    public Users register(Users users){
        repo.save(users);
    }
}
