package org.krkmz.postapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, Long> extends JpaRepository<T, Long> {
    List<T> findByUserIdAndPostId (Long userId, Long postId);

    List<T> findByUserId (Long userId);

    List<T> findByPostId (Long postId);
}
