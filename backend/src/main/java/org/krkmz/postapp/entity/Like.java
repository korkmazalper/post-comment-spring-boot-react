package org.krkmz.postapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table( name = "likes" )
@Data
public class Like {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "post_id" )
    private Long postId;
    @Column( name = "user_id" )
    private Long userId;


}
