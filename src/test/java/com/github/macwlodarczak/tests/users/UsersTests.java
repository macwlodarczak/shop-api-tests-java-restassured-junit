package com.github.macwlodarczak.tests.users;

import com.github.macwlodarczak.api.endpoints.AuthUser;
import com.github.macwlodarczak.api.models.AuthResponse;
import com.github.macwlodarczak.api.models.UserRequest;
import com.github.macwlodarczak.api.utils.ConfigManager;
import com.github.macwlodarczak.tests.base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTests extends BaseTest {
    private final AuthUser userClient = new AuthUser();
    private UserRequest adminUser;

    @Test
    public void should_return_JWT_token_When_admin_signs_in() {
//create adminUser object using admin credentials from config.local.properties file
         adminUser = new UserRequest(ConfigManager.getProperty("admin.username"),
                ConfigManager.getProperty("admin.password"));

        Response response = userClient.signinUser(adminUser);

        String token = response.jsonPath().getString("token");
        AuthResponse authResponse = response.as(AuthResponse.class);

        assertEquals(200, response.getStatusCode(), "Response status code should be 200 OK");
        assertNotNull(token, "token should not be null");
        assertFalse(token.trim().isEmpty(), "token should not be empty");
        assertEquals("admin", authResponse.getUsername(), "username should be admin");



    }
}
