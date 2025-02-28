package com.barbebroux.bikereservationsystem.controller;

import com.barbebroux.bikereservationsystem.dto.BookDTO;
import com.barbebroux.bikereservationsystem.dto.ChangeBikeDTO;
import com.barbebroux.bikereservationsystem.entity.Bike;
import com.barbebroux.bikereservationsystem.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bikes")
public class RiderController {

    @Autowired
    private BikeService bikeService;

    @GetMapping
    public ResponseEntity<List<Bike>> getAllBikes() {
        List<Bike> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(bikes);
    }

    @PostMapping("/book")
    public ResponseEntity<Void> bookBike(@RequestBody BookRequest bookRequest) {
        BookDTO bookDTO = new BookDTO(bookRequest);
        bikeService.bookBike(bookDTO);
        return ResponseEntity.created(URI.create("bikes/book")).build();
    }

    @PostMapping("/changeBike")
    public ResponseEntity<Void> changeBike(@RequestBody ChangeBikeRequest changeBikeRequest) {
        ChangeBikeDTO changeBikeDTO = new ChangeBikeDTO(changeBikeRequest);
        bikeService.updateBike(changeBikeDTO);
        return ResponseEntity.created(URI.create("bikes/changeBike")).build();
    }


    public record BookRequest(UUID bikeId, LocalDateTime rentalDate, LocalDateTime endOfRentalDate, String zipCode) {}

    public record ChangeBikeRequest(UUID currentBikeID, UUID newBikeID, LocalDateTime rentalDate, LocalDateTime endOfRentalDate) {}

}
