package com.cherkassy.heroes.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    private Role role;
}