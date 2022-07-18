package com.example.bunjang.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Product") //table 이름
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "title", nullable = false, length = 20)
    private String title;

    @Column(name = "category", nullable = false,  length = 20)
    private String category;

    @Column(name = "price", nullable = false, length = 11)
    private int price;

    @Column(length = 500)
    private String explanation;

    private String sellStatus;

    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
