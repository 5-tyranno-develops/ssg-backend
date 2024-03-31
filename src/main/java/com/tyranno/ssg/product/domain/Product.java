package com.tyranno.ssg.product.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName; // 상품 이름

    @Column(nullable = false)
    private Integer productPrice; //상품 가격

    @Column(nullable = false)
    private Float productRate; // 평점

    @Column(columnDefinition = "TEXT", nullable = false)
    private String detailContent; // 상세설명

    @Column(nullable = false)
    private Integer reviewCount; // 리뷰 갯수

    @Builder
    public Product(Long id, String productName, Integer productPrice, Float productRate, String detailContent, Integer reviewCount) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productRate = productRate;
        this.detailContent = detailContent;
        this.reviewCount = reviewCount;
    }
}
