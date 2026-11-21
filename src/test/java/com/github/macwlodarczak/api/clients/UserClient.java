package com.github.macwlodarczak.api.clients;

import com.github.macwlodarczak.api.models.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final String SIGNIN_PATH = "/api/v1/users/signin";

    public Response getToken(User user) {

        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(SIGNIN_PATH)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
