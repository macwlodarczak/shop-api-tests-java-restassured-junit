package com.github.macwlodarczak.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse extends UserResponse{
    private String token;
    private String refreshToken;

    public AuthResponse() {
    }

    public AuthResponse(String refreshToken, String token) {
        this.refreshToken = refreshToken;
        this.token = token;
    }

    public AuthResponse(String email, String firstName, String lastName, String[] roles, String refreshToken, String token) {
        super(email, firstName, lastName, roles);
        this.refreshToken = refreshToken;
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
