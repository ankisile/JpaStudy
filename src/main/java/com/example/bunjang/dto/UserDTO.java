package com.example.bunjang.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

//REQUEST 데이터를 받는다!
@Log4j2
@Getter
@Setter
@ToString
public class UserDTO {

    private Long num;

    private String title;

    private String content;

    private String writerEmail;

    private LocalDateTime regDate, modDate;


}
