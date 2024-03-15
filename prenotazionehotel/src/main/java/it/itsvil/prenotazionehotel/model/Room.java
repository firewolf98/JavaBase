package it.itsvil.prenotazionehotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "price_one_night")
    private double priceOneNight;
}
