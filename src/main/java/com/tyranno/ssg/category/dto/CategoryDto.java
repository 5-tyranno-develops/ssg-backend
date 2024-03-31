package com.tyranno.ssg.category.dto;

import com.tyranno.ssg.product.dto.ProductInformationDto;
import lombok.*;

@Getter
@NoArgsConstructor
public class CategoryDto {
    private ProductInformationDto product;
    private Long detailId;
    private Long smallId;
    private Long middleId;
    private Long largeId;

    @Builder
    public CategoryDto(ProductInformationDto product, Long detailId, Long smallId, Long middleId, Long largeId) {
        this.product = product;
        this.detailId = detailId;
        this.smallId = smallId;
        this.middleId = middleId;
        this.largeId = largeId;
    }
}
