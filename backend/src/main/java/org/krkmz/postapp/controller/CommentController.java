package org.krkmz.postapp.controller;

import org.krkmz.postapp.entity.Comment;
import org.krkmz.postapp.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping( "/comments" )
@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments (@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {

    }
}
