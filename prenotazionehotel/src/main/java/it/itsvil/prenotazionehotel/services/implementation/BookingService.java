package it.itsvil.prenotazionehotel.services.implementation;

import it.itsvil.prenotazionehotel.model.Booking;
import it.itsvil.prenotazionehotel.repository.BookingRepository;
import it.itsvil.prenotazionehotel.services.interfaces.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements BookingServiceInterface {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking save(Booking booking) {
        if (isBookingAvailable(booking)) {
            return bookingRepository.save(booking);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Optional<Booking> existingBookingOptional = findById(id);
        if (existingBookingOptional.isPresent()) {
            Booking existingBooking = existingBookingOptional.get();
            existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
            existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
            existingBooking.setRoom(updatedBooking.getRoom());
            return bookingRepository.save(existingBooking);
        } else {
            return null;
        }
    }

    private boolean isBookingAvailable(Booking booking) {
        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(
                booking.getCheckInDate(), booking.getCheckOutDate(), booking.getId());
        return conflictingBookings.isEmpty();
    }
}
