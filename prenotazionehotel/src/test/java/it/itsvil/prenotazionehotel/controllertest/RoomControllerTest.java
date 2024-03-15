package it.itsvil.prenotazionehotel.controllertest;

import it.itsvil.prenotazionehotel.controller.RoomController;
import it.itsvil.prenotazionehotel.services.implementation.RoomService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoomControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    RoomService roomService;

    @InjectMocks
    RoomController roomController;

    @Test
    public void mappingValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void mappingNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/roomsss")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
