package com.example.bunjang.service;

import com.example.bunjang.config.Salt;
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
        String password = user.getPassword();
        String salt = saltUtil.genSalt();
        user.setSalt(new Salt(salt));
        user.setPassword(saltUtil.encodePassword(salt,password));
        userRepository.save(user);
    }
}
