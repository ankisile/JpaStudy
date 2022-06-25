package com.example.bunjang.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User") //table 이름
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "userName", nullable = false, length = 10)
    private String userName;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(name = "phone", nullable = false, length = 11)
    private String phone;

    @Column(length = 200)
    private String profileUrl;

    @Column(columnDefinition = "int default 0")
    private Integer point;

    @Column(columnDefinition = "varchar(10) default 'ACTIVE'")
    private String status;

}
