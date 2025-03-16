package org.krkmz.postapp.repository;

import org.krkmz.postapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId (Long userId);
}
