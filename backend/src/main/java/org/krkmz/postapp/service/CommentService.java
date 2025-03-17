package org.krkmz.postapp.service;

import org.krkmz.postapp.entity.Comment;
import org.krkmz.postapp.entity.Post;
import org.krkmz.postapp.entity.User;
import org.krkmz.postapp.repository.CommentRepository;
import org.krkmz.postapp.requests.CommentCreateRequest;
import org.krkmz.postapp.requests.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;

    public CommentService (CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllCommentsWithParams (Optional<Long> userId, Optional<Long> postId) {
        if ( userId.isPresent() && postId.isPresent() ) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if ( userId.isPresent() ) {
            return commentRepository.findByUserId(userId.get());
        } else if ( postId.isPresent() ) {
            return commentRepository.findByPostId(postId.get());
        } else {
            return commentRepository.findAll();
        }
    }

    public Comment getCommentById (Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment (CommentCreateRequest request) {
        User user = userService.getUserById(request.getUserId());
        Post post = postService.getPostById(request.getPostId());
        if ( user != null && post != null ) {
            Comment commentToSave = new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(request.getText());
            return commentRepository.save(commentToSave);
        } else {
            return null;
        }
    }

    public Comment update (Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if ( comment.isPresent() ) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(request.getText());
            return commentRepository.save(commentToUpdate);
        }
        return null;
    }

    public void deleteCommentById (Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
