package com.example.bunjang.controller;

import com.example.bunjang.dto.RegisterReqDTO;
import com.example.bunjang.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping("/app/users")
public class UserController {

    private final UserService userService;

    @PostMapping(value="")
    public ResponseEntity<String> register(@RequestBody RegisterReqDTO registerReqDTO){

        log.info("---------reigster-----------");
        log.info(registerReqDTO);

        userService.register(registerReqDTO);

        return new ResponseEntity<>("registered", HttpStatus.OK);
    }

}
