package com.cherkassy.heroes.secutiry;

import lombok.Data;

@Data
public class LoginForm {
    private String email;
    private String password;
}