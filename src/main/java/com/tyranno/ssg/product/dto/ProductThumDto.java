package com.tyranno.ssg.product.dto;

import com.tyranno.ssg.product.domain.ProductThum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductThumDto {

    private String imageUrl; // 이미지링크
    private Byte priority; // 우선순위
    private String imageName; // alt

    public static ProductThumDto FromEntity(ProductThum productThum) {
        return ProductThumDto.builder()
                .imageUrl(productThum.getImageUrl())
                .imageName(productThum.getImageName())
                .build();
    }
}
