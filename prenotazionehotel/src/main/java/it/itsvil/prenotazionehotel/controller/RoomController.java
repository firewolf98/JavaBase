package it.itsvil.prenotazionehotel.controller;

import it.itsvil.prenotazionehotel.model.Room;
import it.itsvil.prenotazionehotel.services.implementation.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/{roomNumber}")
    public ResponseEntity<Room> getRoomByRoomNumber(@PathVariable int roomNumber) {
        Optional<Room> room = roomService.findByRoomNumber(roomNumber);
        return room.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.findAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.save(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @PutMapping("/{roomNumber}")
    public ResponseEntity<Room> updateRoom(@PathVariable int roomNumber, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(roomNumber, room);
        if (updatedRoom != null) {
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomNumber) {
        roomService.deleteByRoomNumber(roomNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
