package com.tyranno.ssg.product.dto;

import com.tyranno.ssg.product.domain.Product;
import com.tyranno.ssg.users.domain.Users;
import com.tyranno.ssg.users.dto.UsersInfoDto;
import lombok.*;

@Getter
@NoArgsConstructor
public class ProductInformationDto {
    private Long productId;
    private String productName;
    private int price;
    private float productRate;
    private int reviewCount;

    @Builder
    public ProductInformationDto(Long productId, String productName, int price, float productRate, int reviewCount) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productRate = productRate;
        this.reviewCount = reviewCount;
    }

    public static ProductInformationDto FromEntity(Product product) {
        return ProductInformationDto.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .price(product.getProductPrice())
                .productRate(product.getProductRate())
                .reviewCount(product.getReviewCount())
                .build();
    }
}