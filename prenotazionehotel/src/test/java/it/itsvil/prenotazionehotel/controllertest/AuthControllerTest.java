package it.itsvil.prenotazionehotel.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.itsvil.prenotazionehotel.controller.AuthController;
import it.itsvil.prenotazionehotel.model.User;
import it.itsvil.prenotazionehotel.services.implementation.UserAuth;
import it.itsvil.prenotazionehotel.services.interfaces.UserAuthInterface;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    UserAuth userAuth;

    @InjectMocks
    AuthController authController;

    @Test
    public void loginMappingValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void loginMappingNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/loginnnnnnn")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void loginUserValid() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userAuth.login("email","password")).thenReturn(user);

        assertEquals(ResponseEntity.ok(user),authController.login(user));
    }

    @Test
    public void loginUserNotValid() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userAuth.login("email","password")).thenReturn(null);

        assertEquals(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null),authController.login(user));
    }

    @Test
    public void signinMappingValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signin")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void signinMappingNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signinnn")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void signinUserValid() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userAuth.signin(new User("email","password"))).thenReturn(user);

        assertEquals(ResponseEntity.ok(user),authController.signin(user));
    }

    @Test
    public void signinUserNotValid() {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");

        when(userAuth.signin(new User("email","password"))).thenReturn(null);

        assertEquals(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null),authController.signin(user));
    }

}
