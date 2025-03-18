package org.krkmz.postapp.responses;

import org.krkmz.postapp.entity.Post;

import java.time.LocalDateTime;

public class PostResponse {
    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PostResponse (Post post) {
        this.id = post.getId();
        this.userId = post.getUser().getId();
        this.userName = post.getUser().getUserName();
        this.title = post.getTitle();
        this.text = post.getText();
        this.createdAt = post.getCreatedAt();
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }
}
