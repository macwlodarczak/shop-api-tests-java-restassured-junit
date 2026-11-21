package com.github.macwlodarczak.api.models;

public class UserResponse extends UserRequest{
    private String[] roles;
    private int id;

    public UserResponse() {
    }

    public UserResponse(String email, String firstName, String lastName, String[] roles) {
        super(email, firstName, lastName);
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
