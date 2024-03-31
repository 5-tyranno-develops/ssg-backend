package com.tyranno.ssg.category.dto;

import lombok.*;

@Getter
@NoArgsConstructor
public class MiddleCategoryDto {
    private Long middleId;
    private String middleName;
    private String middleImageUrl;

    @Builder
    public MiddleCategoryDto(Long middleId, String middleName, String middleImageUrl) {
        this.middleId = middleId;
        this.middleName = middleName;
        this.middleImageUrl = middleImageUrl;
    }
}
