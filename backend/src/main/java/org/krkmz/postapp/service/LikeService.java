package org.krkmz.postapp.service;

import org.krkmz.postapp.entity.Like;
import org.krkmz.postapp.entity.Post;
import org.krkmz.postapp.entity.User;
import org.krkmz.postapp.repository.LikeRepository;
import org.krkmz.postapp.requests.LikeCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;

    public LikeService (LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> createLike (Optional<Long> userId, Optional<Long> postId) {
        return ServiceHelper.createCommentOrLike(likeRepository, userId, postId);
    }

    public Like getLikeById (Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }


    public Like createComment (LikeCreateRequest request) {
        User user = userService.getUserById(request.getUserId());
        Post post = postService.getPostById(request.getPostId());
        if ( user != null && post != null ) {
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return likeRepository.save(likeToSave);
        } else {
            return null;
        }
    }


}
