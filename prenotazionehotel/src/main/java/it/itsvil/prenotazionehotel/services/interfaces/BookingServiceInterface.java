package it.itsvil.prenotazionehotel.services.interfaces;

import it.itsvil.prenotazionehotel.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookingServiceInterface {
    Booking save(Booking booking);

    Optional<Booking> findById(Long id);

    List<Booking> findAllBookings();

    void deleteById(Long id);

    Booking updateBooking(Long id, Booking updatedBooking);
}
