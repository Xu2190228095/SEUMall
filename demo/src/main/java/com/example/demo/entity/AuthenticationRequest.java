package com.example.demo.entity;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String character;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}

