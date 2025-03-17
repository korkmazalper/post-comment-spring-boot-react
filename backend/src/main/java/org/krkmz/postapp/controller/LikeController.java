package org.krkmz.postapp.controller;

import org.krkmz.postapp.entity.Like;
import org.krkmz.postapp.requests.LikeCreateRequest;
import org.krkmz.postapp.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping( "/likes" )
@RestController
public class LikeController {
    private final LikeService likeService;

    public LikeController (LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLikes (@RequestParam Optional<Long> userId, Optional<Long> postId) {
        return likeService.createLike(userId, postId);
    }

    @GetMapping( "/{likeId}" )
    public Like getLike (@PathVariable Long likeId) {
        return likeService.getLikeById(likeId);
    }

    @PostMapping
    public Like createComment (@RequestBody LikeCreateRequest request) {
        return likeService.createComment(request);
    }
}
