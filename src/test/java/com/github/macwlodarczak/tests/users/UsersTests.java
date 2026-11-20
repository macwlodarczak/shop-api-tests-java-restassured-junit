package com.github.macwlodarczak.tests.users;

import com.github.macwlodarczak.api.clients.UserClient;
import com.github.macwlodarczak.base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTests extends BaseTest {
    private final UserClient userClient = new UserClient();

    @Test
    public void shouldReturnUserToken() {
        String payload = "{\"username\": \"admin\", \"password\": \"LocalDemoAdmin123!\"}";
        Response response = userClient.getToken(payload);
        assertEquals(200, response.getStatusCode(), "Kod odpowiedzi powinien wynosić 200 OK");
    }
}
