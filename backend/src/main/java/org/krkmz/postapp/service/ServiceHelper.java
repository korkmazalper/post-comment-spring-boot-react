package org.krkmz.postapp.service;

import org.krkmz.postapp.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public class ServiceHelper {
    public static <T> List<T> createCommentOrLike (BaseRepository baseRepository, Optional<Long> userId,
                                                   Optional<Long> postId) {
        if ( userId.isPresent() && postId.isPresent() ) {
            return baseRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if ( userId.isPresent() ) {
            return baseRepository.findByUserId(userId.get());
        } else if ( postId.isPresent() ) {
            return baseRepository.findByPostId(postId.get());
        } else {
            return baseRepository.findAll();
        }
    }
}
