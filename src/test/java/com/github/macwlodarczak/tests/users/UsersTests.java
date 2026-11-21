package com.github.macwlodarczak.tests.users;

import com.github.macwlodarczak.api.clients.UserClient;
import com.github.macwlodarczak.api.models.User;
import com.github.macwlodarczak.base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTests extends BaseTest {
    private final UserClient userClient = new UserClient();
    private User user = new User();

    @Test
    public void shouldReturnUserToken() {
//set admin credentials
        user.setUsername("admin");
        user.setPassword("LocalDemoAdmin123!");
        Response response = userClient.getToken(user);

        String token = response.jsonPath().getString("token");

        assertEquals(200, response.getStatusCode(), "Response status code should be 200 OK");
        assertNotNull(token, "token should not be null");
        assertFalse(token.trim().isEmpty(), "token should not be empty");
        assertTrue(token.contains("."));
    }
}
