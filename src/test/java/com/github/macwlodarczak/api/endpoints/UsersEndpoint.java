package com.github.macwlodarczak.api.endpoints;

import com.github.macwlodarczak.api.models.GetUserReq;
import com.github.macwlodarczak.api.models.UserRequest;
import com.github.macwlodarczak.api.specs.ApiSpecs;
import com.github.macwlodarczak.api.utils.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class UsersEndpoint {
    private static final String GET_USER_BY_USERNAME_PATH = String.format("/api/v1/users/%s",
            ConfigManager.getProperty("admin.username"));
    public Response getUserByUsername(String token) {

//        postman request 'http://192.168.1.190:8081/api/v1/users' \
//        --header 'Authorization: ••••••' \
//        --auth-bearer-token 'eyJhbGci

        return given()
                .spec(ApiSpecs.authRequestSpecs(token))
                .when()
                .get(GET_USER_BY_USERNAME_PATH);
    }


}
