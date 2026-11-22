package com.github.macwlodarczak.api.endpoints;

import com.github.macwlodarczak.api.models.UserRequest;
import com.github.macwlodarczak.api.specs.ApiSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthUser {
    private static final String SIGNIN_PATH = "/api/v1/users/signin";

    public Response signinUser(UserRequest user) {

        return given()
                .spec(ApiSpecs.defaultReqSpec())
                .body(user)
                .when()
                .post(SIGNIN_PATH);
//                .then()
//                .statusCode(200)
//                .extract()
//                .response();
    }
}
