package org.krkmz.postapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table( name = "likes" )
@Data
public class Like {
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


}
