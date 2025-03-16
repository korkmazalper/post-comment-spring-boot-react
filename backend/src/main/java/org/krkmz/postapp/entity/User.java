package org.krkmz.postapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table( name = "users" )
@Data
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "username" )
    private String userName;
    @Column( name = "password" )
    private String password;

}
