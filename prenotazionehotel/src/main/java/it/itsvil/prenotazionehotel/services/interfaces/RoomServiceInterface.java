package it.itsvil.prenotazionehotel.services.interfaces;

import it.itsvil.prenotazionehotel.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomServiceInterface {
    Room save(Room room);

    Optional<Room> findByRoomNumber(int roomNumber);

    List<Room> findAllRooms();

    void deleteByRoomNumber(int roomNumber);

    Room updateRoom(int roomNumber, Room updatedRoom);
}
