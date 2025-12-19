package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    // ✅ REQUIRED constructor (tests expect this)
    public AuthResponse(String token, Object userId, Object email, Object role) {
        this.token = token;
        this.userId = (Long) userId;
        this.email = (String) email;
        this.role = (String) role;
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
