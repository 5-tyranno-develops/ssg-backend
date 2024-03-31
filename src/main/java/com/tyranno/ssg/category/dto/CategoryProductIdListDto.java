package com.tyranno.ssg.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CategoryProductIdListDto {
    private List<Long> productIds;

    @Builder
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
