package com.github.macwlodarczak.tests.users;

import com.github.macwlodarczak.api.endpoints.UsersSignin;
import com.github.macwlodarczak.api.endpoints.UsersEndpoints;
import com.github.macwlodarczak.api.models.AuthResponse;
import com.github.macwlodarczak.api.models.UserRequestDto;
import com.github.macwlodarczak.api.models.UserResponse;
import com.github.macwlodarczak.api.utils.ConfigManager;
import com.github.macwlodarczak.tests.base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTests extends BaseTest {
//    private final AuthUser userClient = new AuthUser();

    @Test
    public void should_return_JWT_token_When_admin_logs_in() {
//create UserRequest object using admin credentials from config.local.properties file
        UserRequestDto user = new UserRequestDto(ConfigManager.getProperty("admin.username"),
                ConfigManager.getProperty("admin.password"));

        Response response = new UsersSignin().logUserIn(user);

        AuthResponse authResponse = response.as(AuthResponse.class);
        String token = authResponse.getToken();
        String refreshToken = authResponse.getRefreshToken();

        assertEquals(200, response.getStatusCode(), "Response status code should be 200 OK");
        assertNotNull(token, "token should not be null");
        assertFalse(token.trim().isEmpty(), "token should not be empty");
        assertFalse(refreshToken.trim().isEmpty(), "refreshtoken should not be empty");
    }

    @Test
    public void should_return_user_data_When_admin_logs_in() {
//create UserRequest object using admin credentials from config.local.properties file
        UserRequestDto user = new UserRequestDto(ConfigManager.getProperty("admin.username"),
                ConfigManager.getProperty("admin.password"));

        Response response = new UsersSignin().logUserIn(user);

        AuthResponse authResponse = response.as(AuthResponse.class);

        assertEquals(200, response.getStatusCode(), "Response status code should be 200 OK");
        assertEquals("admin", authResponse.getUsername(), "username should be admin");
        assertEquals("Slawomir", authResponse.getFirstName(), "firstname should be Slawomir");
        assertEquals("Radzyminski", authResponse.getLastName(), "lastname should be Radzyminski");
        assertEquals("awesome@testing.com", authResponse.getEmail(), "email should be awesome@testing.com");
        assertEquals("ROLE_ADMIN", authResponse.getUserRoles().trim().strip(), "roles should be ROLE_ADMIN");
    }

    @Test
    public void should_return_user_data_When_get_user_by_username() {

        UserRequestDto user = new UserRequestDto(ConfigManager.getProperty("admin.username"),
                ConfigManager.getProperty("admin.password"));
        Response response = new UsersSignin().logUserIn(user);
        AuthResponse auth = response.as(AuthResponse.class);
        String token = auth.getToken();

        Response resp = new UsersEndpoints().getUserByUsername(token);

        UserResponse ur = resp.as(UserResponse.class);

        assertEquals("admin", ur.getUsername(), "username should be admin");
        assertEquals(1, ur.getId(), "id should be 1");
        assertEquals("ROLE_ADMIN", ur.getUserRoles().trim().strip(), "roles should be ROLE_ADMIN");
        assertEquals("awesome@testing.com", ur.getEmail(), "email should be awesome@testing.com");
        assertEquals("Slawomir", ur.getFirstName(), "firstName should be Slawomir");
        assertEquals("Radzyminski", ur.getLastName(), "lastName should be Radzyminski");

    }
}