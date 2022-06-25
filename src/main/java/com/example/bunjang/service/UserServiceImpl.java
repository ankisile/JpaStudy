package com.example.bunjang.service;

import com.example.bunjang.entity.User;
import com.example.bunjang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(User user) {
        userRepository.save(user);
    }
}
