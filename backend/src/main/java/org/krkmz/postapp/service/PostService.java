package org.krkmz.postapp.service;

import org.krkmz.postapp.entity.Post;
import org.krkmz.postapp.entity.User;
import org.krkmz.postapp.repository.PostRepository;
import org.krkmz.postapp.requests.PostCreateRequest;
import org.krkmz.postapp.requests.PostUpdateRequest;
import org.krkmz.postapp.responses.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService (PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<PostResponse> getAllPosts (Optional<Long> userId) {
        List<Post> list;
        if ( userId.isPresent() ) {
            list = postRepository.findByUserId(userId.get());
        }
        list = postRepository.findAll();
        return list.stream().map((post) -> new PostResponse(post)).collect(Collectors.toList());
    }

    public Post getPostById (Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createPost (PostCreateRequest newPostRequest) {
        User user = userService.getUserById(newPostRequest.getUserId());
        if ( user == null ) {
            throw new IllegalArgumentException("User not found with ID: " + newPostRequest.getUserId());
        }
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post updatePostById (Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if ( post.isPresent() ) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    public void deleteById (Long postId) {
        postRepository.deleteById(postId);
    }
}
