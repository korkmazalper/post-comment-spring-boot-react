package org.krkmz.postapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table( name = "comments" )
@Data
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "post_id" )
    private Long postId;
    @Column( name = "user_id" )
    private Long userId;
    @Lob
    @Column( columnDefinition = "text" )
    private String text;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
