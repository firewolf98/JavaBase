package it.itsvil.prenotazionehotel.servicetest;

import it.itsvil.prenotazionehotel.model.Booking;
import it.itsvil.prenotazionehotel.repository.BookingRepository;
import it.itsvil.prenotazionehotel.services.implementation.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    public void bookingValid() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setCheckInDate(LocalDate.of(2024, 3, 12));
        booking.setCheckOutDate(LocalDate.of(2024, 3, 15));
        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking savedBooking = bookingService.save(booking);

        assertNotNull(savedBooking);
        assertNotNull(savedBooking.getId());
        assertEquals(booking.getCheckInDate(), savedBooking.getCheckInDate());
        assertEquals(booking.getCheckOutDate(), savedBooking.getCheckOutDate());
    }

    @Test
    public void bookingNotValid() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setCheckInDate(LocalDate.of(2024, 3, 12));
        booking.setCheckOutDate(LocalDate.of(2024, 3, 15));
        when(bookingRepository.save(booking)).thenReturn(null);

        Booking savedBooking = bookingService.save(booking);

        assertNull(savedBooking);
    }
}
