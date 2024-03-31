package com.tyranno.ssg.like.application;

import com.tyranno.ssg.like.dto.LikeDto;

public interface LikeService {
    LikeDto getLikeByProductIdAndUsersId(Long productId, Long usersId);
}
