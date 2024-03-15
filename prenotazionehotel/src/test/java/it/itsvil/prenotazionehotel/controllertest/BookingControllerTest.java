package it.itsvil.prenotazionehotel.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.itsvil.prenotazionehotel.controller.AuthController;
import it.itsvil.prenotazionehotel.controller.BookingController;
import it.itsvil.prenotazionehotel.model.User;
import it.itsvil.prenotazionehotel.services.implementation.BookingService;
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
public class BookingControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    BookingService bookingService;

    @InjectMocks
    BookingController bookingController;

    @Test
    public void mappingValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bookings")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void mappingNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bookingsss")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
