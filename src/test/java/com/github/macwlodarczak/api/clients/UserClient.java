package com.github.macwlodarczak.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private final String SIGNIN_PATH = "/api/v1/users/signin";
    public Response getToken(String jsonBody) {

        return given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post(SIGNIN_PATH);

    }
}
