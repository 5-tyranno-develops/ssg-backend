package com.tyranno.ssg.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SmallCategoryDto {
    private Long smallId;
    private String smallName;

    @Builder
    public SmallCategoryDto(Long smallId, String smallName) {
        this.smallId = smallId;
        this.smallName = smallName;
    }
}
