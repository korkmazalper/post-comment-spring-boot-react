package org.krkmz.postapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table( name = "posts" )
public class Post {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "user_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    @JsonIgnore
    private User user;
    @Column( name = "title" )
    private String title;
    @Lob
    @Column( columnDefinition = "text" )
    private String text;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
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

    public LocalDateTime getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt () {
        return updatedAt;
    }

    public void setUpdatedAt (LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
