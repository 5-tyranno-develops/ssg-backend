package com.tyranno.ssg.category.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class LargeCategoryDto {
    private Long largeId;
    private String largeName;
    private String largeImageUrl;
    @Builder
    public LargeCategoryDto(Long largeId, String largeName, String largeImageUrl) {
        this.largeId = largeId;
        this.largeName = largeName;
        this.largeImageUrl = largeImageUrl;
    }
}
