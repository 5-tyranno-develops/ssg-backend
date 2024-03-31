package com.tyranno.ssg.like.infrastructure;

import com.tyranno.ssg.like.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByProductIdAndUsersId(Long productId, Long usersId);
}
