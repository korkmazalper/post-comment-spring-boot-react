package org.krkmz.postapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.krkmz.postapp.entity.Comment;
import org.krkmz.postapp.requests.CommentCreateRequest;
import org.krkmz.postapp.requests.CommentUpdateRequest;
import org.krkmz.postapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping( "/comments" )
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(
            summary = "Get Comments API",
            description = "Get Comments API to get objects from database"
    )
    @GetMapping
    public List<Comment> getAllComments (@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParams(userId, postId);
    }

    @GetMapping( "/{commentId}" )
    public Comment getComment (@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping
    public Comment createComment (@RequestBody CommentCreateRequest request) {
        return commentService.createComment(request);
    }

    @PutMapping( "/{commentId}" )
    public Comment updateComment (@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
        return commentService.update(commentId, request);
    }

    @DeleteMapping( "/{commentId}" )
    public void deleteComment (@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
    }


}
