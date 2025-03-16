package org.krkmz.postapp.controller;

import org.krkmz.postapp.entity.Post;
import org.krkmz.postapp.requests.PostCreateRequest;
import org.krkmz.postapp.requests.PostUpdateRequest;
import org.krkmz.postapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping( "/posts" )
@RestController
public class PostController {
    private final PostService postService;

    public PostController (PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts (@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @GetMapping( "/{postId}" )
    public Post getPost (@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createPost (@RequestBody PostCreateRequest newPostRequest) {
        return postService.createPost(newPostRequest);
    }

    @PutMapping( "/{postId}" )
    public Post updatePost (@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updatePostById(postId, updatePost);
    }

    @DeleteMapping( "/{postId}" )
    public void deletePost (@PathVariable Long postId) {
        postService.deleteById(postId);
    }

}
