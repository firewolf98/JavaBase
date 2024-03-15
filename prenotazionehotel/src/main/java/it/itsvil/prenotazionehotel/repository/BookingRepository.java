package it.itsvil.prenotazionehotel.repository;

import it.itsvil.prenotazionehotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b " +
            "WHERE (:checkInDate BETWEEN b.checkInDate AND b.checkOutDate " +
            "OR :checkOutDate BETWEEN b.checkInDate AND b.checkOutDate) " +
            "AND (b.id <> :bookingId OR :bookingId IS NULL)")
    List<Booking> findConflictingBookings(@Param("checkInDate") LocalDate checkInDate,
                                          @Param("checkOutDate") LocalDate checkOutDate,
                                          @Param("bookingId") Long bookingId);
}

