package com.tyranno.ssg.category.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class DetailCategoryDto {
    private Long detailId;
    private String detailName;

    @Builder
    public DetailCategoryDto(Long detailId, String detailName) {
        this.detailId = detailId;
        this.detailName = detailName;
    }
}
