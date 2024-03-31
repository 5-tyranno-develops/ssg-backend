package com.tyranno.ssg.product.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@Getter
public class ProductThum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private String imageUrl; // 이미지링크

    @Column(nullable = false)
    private Byte priority; // 우선순위

    private String imageName; // alt

    @Builder
    public ProductThum(Long id, Product product, String imageUrl, Byte priority, String imageName) {
        this.id = id;
        this.product = product;
        this.imageUrl = imageUrl;
        this.priority = priority;
        this.imageName = imageName;
    }
}
