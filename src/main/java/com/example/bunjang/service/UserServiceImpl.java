package com.example.bunjang.service;

import com.example.bunjang.config.Salt;
import com.example.bunjang.config.SaltUtil;
import com.example.bunjang.entity.User;
import com.example.bunjang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(User user) {
        String password = user.getPassword();

//      비밀번호 해싱
        String encodePassword = passwordEncoder.encode(password);
        
//        User user = User.builder()
//                .email(email)
//                .name(name)
//                .password(encodePassword)
//                .level(1L)
//                .build();

        userRepository.save(user);
    }
}
