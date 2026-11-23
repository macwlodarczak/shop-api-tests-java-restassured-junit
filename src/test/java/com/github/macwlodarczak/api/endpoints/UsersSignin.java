package com.github.macwlodarczak.api.endpoints;

import com.github.macwlodarczak.api.models.UserRequestDto;
import com.github.macwlodarczak.api.specs.ApiSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersSignin {
    private static final String SIGNIN_PATH = "/api/v1/users/signin";

    public Response logUserIn(UserRequestDto user) {

        return given()
                .spec(ApiSpecs.defaultReqSpec())
                .body(user)
                .when()
                .post(SIGNIN_PATH);
    }
}
