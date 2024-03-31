package com.tyranno.ssg.product.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer discount;

    private LocalDateTime discountStart;

    private LocalDateTime discountEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public Discount(Long id, Integer discount, LocalDateTime discountStart, LocalDateTime discountEnd, Product product) {
        this.id = id;
        this.discount = discount;
        this.discountStart = discountStart;
        this.discountEnd = discountEnd;
        this.product = product;
    }
}
