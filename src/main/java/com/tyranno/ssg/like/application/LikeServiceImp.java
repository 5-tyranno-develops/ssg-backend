package com.tyranno.ssg.like.application;

import com.tyranno.ssg.like.dto.LikeDto;
import com.tyranno.ssg.like.infrastructure.LikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LikeServiceImp implements LikeService{
    private final LikeRepository likeRepository;
    @Override
    public LikeDto getLikeByProductIdAndUsersId(Long productId, Long usersId) {
        log.info("productId {}",productId);
        log.info("usersId {}", usersId);
        return likeRepository.findByProductIdAndUsersId(productId, usersId)
                .map(LikeDto::FromEntity)
                .orElse(new LikeDto());
    }
}
