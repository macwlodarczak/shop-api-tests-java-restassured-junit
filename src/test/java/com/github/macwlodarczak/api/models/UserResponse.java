package com.github.macwlodarczak.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends UserRequest{
    private String[] roles;
    private int id;

    public UserResponse() {
    }

    public UserResponse(String email, String firstName, String lastName, String[] roles) {
        super(email, firstName, lastName);
        this.roles = roles;
    }

    public UserResponse(String username, String email, String password, String firstname, String lastName, int id, String[] roles) {
        super(username, email, password, firstname, lastName);
        this.id = id;
        this.roles = roles;
    }

//    public UserResponse(String username) {
//        super(username);
//    }

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

    public String getUserRoles() {
        String [] rolesArray = getRoles();
        String roles = "";
        for (int i = 0; i < rolesArray.length; i++) {
            roles = rolesArray[i] + ", ";
        }
        return roles;
    }

}
