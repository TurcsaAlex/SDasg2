package com.example.asgn2.config.security;

import org.springframework.security.core.userdetails.User;

import java.util.List;

public class AuthUser extends User {

    private final Integer id;

    public AuthUser(Integer id,
                    String username,
                    String encodedPassword) {
        super(username, encodedPassword != null ? encodedPassword : "", List.of());
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
