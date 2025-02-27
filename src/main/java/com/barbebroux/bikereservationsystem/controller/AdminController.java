package com.barbebroux.bikereservationsystem.controller;

import com.barbebroux.bikereservationsystem.dto.BikeDTO;
import com.barbebroux.bikereservationsystem.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private BikeService bikeService;

    @PostMapping(value = "/bikes", consumes = "application/json")
    public ResponseEntity<Void> createBike(@RequestBody BikeRequest bikeRequest) {
        BikeDTO bikeDTO = new BikeDTO(bikeRequest);
        bikeService.createBike(bikeDTO);
        return ResponseEntity.created(URI.create("/bikes")).build();
    }

    @DeleteMapping(value = "/bikes/{bikeId}")
    public ResponseEntity<Void> deleteBike(@PathVariable UUID bikeId) {
        bikeService.removeBike(bikeId);
        return ResponseEntity.noContent().build();
    }


    public record BikeRequest (String bikeName,
                        String bikeType,
                        String bikeSize,
                        LocalDateTime bikeNextAvailabilityDate) {}
}
