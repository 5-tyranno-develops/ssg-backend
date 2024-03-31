package com.tyranno.ssg.like.dto;

import com.tyranno.ssg.like.domain.Like;
import lombok.*;

@Getter
@NoArgsConstructor
public class LikeDto {
    private Long id;
    public static LikeDto FromEntity(Like like) {
        return LikeDto.builder()
                .id(like.getId())
                .build();
    }
    @Builder
    public LikeDto(Long id) {
        this.id = id;
    }
}
