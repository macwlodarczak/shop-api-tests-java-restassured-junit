package com.github.macwlodarczak.base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static final String baseURI = "http://192.168.1.190";
    private static final int port = 8081;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = baseURI;
        RestAssured.port = port;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
