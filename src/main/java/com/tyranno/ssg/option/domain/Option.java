package com.tyranno.ssg.option.domain;

import com.tyranno.ssg.product.domain.Product;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Getter
@Table(name = "`option`")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    private Etc etc;

    @ManyToOne(fetch = FetchType.LAZY)
    private Extra extra;

    @Column(nullable = false)
    private Integer stock;


    @Builder
    public Option(Long id, Product product, Size size, Color color, Etc etc, Extra extra, Integer stock) {
        this.id = id;
        this.product = product;
        this.size = size;
        this.color = color;
        this.etc = etc;
        this.extra = extra;
        this.stock = stock;
    }
}
