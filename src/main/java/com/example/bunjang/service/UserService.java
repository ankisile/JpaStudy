package com.example.bunjang.service;

import com.example.bunjang.dto.RegisterReqDTO;
import com.example.bunjang.entity.User;

public interface UserService {

    void register(RegisterReqDTO registerReqDTO);

//    void login(String email);

}
