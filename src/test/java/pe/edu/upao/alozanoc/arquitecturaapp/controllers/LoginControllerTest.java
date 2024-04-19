package pe.edu.upao.alozanoc.arquitecturaapp.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pe.edu.upao.alozanoc.arquitecturaapp.controller.LoginController;
import pe.edu.upao.alozanoc.arquitecturaapp.serializers.LoginRequest;
import pe.edu.upao.alozanoc.arquitecturaapp.services.AuthenticationService;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private AuthenticationService userService;

    @InjectMocks
    private LoginController loginController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    void testLoginReturnsOkWhenServiceReturnsTrue() throws Exception {
        // Given
        when(userService.login("admin", "admin")).thenReturn(true);

        // When/Then
        mockMvc.perform(
                post("/api/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new LoginRequest("admin", "admin"))))
               .andExpect(status().isOk());
    }

    @Test
    void testLoginReturnsNoAuthorizedWhenServiceReturnsFalse() throws Exception {
        // Given
        when(userService.login("admin", "incorrect")).thenReturn(false);

        // When/Then
        mockMvc.perform(
                        post("/api/v1/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(asJsonString(new LoginRequest("admin", "incorrect"))))
                .andExpect(status().isUnauthorized());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
