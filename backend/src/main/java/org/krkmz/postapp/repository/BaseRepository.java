package org.krkmz.postapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, Long> extends JpaRepository<T, Long> {
    List<T> findByUserIdAndPostId (java.lang.Long userId, java.lang.Long postId);

    List<T> findByUserId (java.lang.Long userId);

    List<T> findByPostId (java.lang.Long postId);
}
