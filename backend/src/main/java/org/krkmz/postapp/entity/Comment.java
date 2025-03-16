package org.krkmz.postapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table( name = "comments" )
@Data
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "post_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    @JsonIgnore
    private Post post;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "user_id", nullable = false )
    @OnDelete( action = OnDeleteAction.CASCADE )
    @JsonIgnore
    private User user;
    @Lob
    @Column( columnDefinition = "text" )
    private String text;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
