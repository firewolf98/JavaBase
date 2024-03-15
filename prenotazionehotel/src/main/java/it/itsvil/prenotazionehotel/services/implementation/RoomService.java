package it.itsvil.prenotazionehotel.services.implementation;

import it.itsvil.prenotazionehotel.model.Room;
import it.itsvil.prenotazionehotel.repository.RoomRepository;
import it.itsvil.prenotazionehotel.services.interfaces.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements RoomServiceInterface {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> findByRoomNumber(int roomNumber) {
        return roomRepository.findById(roomNumber);
    }

    @Override
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void deleteByRoomNumber(int roomNumber) {
        roomRepository.deleteById(roomNumber);
    }

    @Override
    public Room updateRoom(int roomNumber, Room updatedRoom) {
        Optional<Room> existingRoomOptional = findByRoomNumber(roomNumber);
        if (existingRoomOptional.isPresent()) {
            Room existingRoom = existingRoomOptional.get();
            existingRoom.setCapacity(updatedRoom.getCapacity());
            existingRoom.setPriceOneNight(updatedRoom.getPriceOneNight());
            return roomRepository.save(existingRoom);
        } else {
            return null;
        }
    }
}
