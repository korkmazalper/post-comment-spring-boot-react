package org.krkmz.postapp.repository;

import org.krkmz.postapp.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
