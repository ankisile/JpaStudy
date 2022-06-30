package com.example.bunjang.service;

//import com.example.bunjang.config.Salt;
//import com.example.bunjang.config.SaltUtil;
import com.example.bunjang.dto.RegisterReqDTO;
import com.example.bunjang.entity.User;
import com.example.bunjang.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register(RegisterReqDTO registerReqDTO) {

        String encodePassword = passwordEncoder.encode(registerReqDTO.getPassword());

        User user = User.builder()
                .email(registerReqDTO.getEmail())
                .password(encodePassword)
                .phone(registerReqDTO.getPhoneNumber())
                .userName(registerReqDTO.getUserName())
                .point(0)
                .build();
        String password = user.getPassword();

        userRepository.save(user);
    }
}
