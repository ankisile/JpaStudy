package com.example.bunjang.service;

import com.example.bunjang.dto.RegisterReqDTO;
import com.example.bunjang.dto.UserResDTO;
import com.example.bunjang.entity.User;

public interface UserService {

    void register(RegisterReqDTO registerReqDTO);
    UserResDTO findUserInfo();
//    void login(String email);

}
