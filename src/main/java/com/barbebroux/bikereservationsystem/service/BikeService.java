package com.barbebroux.bikereservationsystem.service;

import com.barbebroux.bikereservationsystem.dto.BikeDTO;
import com.barbebroux.bikereservationsystem.dto.BookDTO;
import com.barbebroux.bikereservationsystem.dto.ChangeBikeDTO;
import com.barbebroux.bikereservationsystem.entity.Bike;
import com.barbebroux.bikereservationsystem.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BikeService {

    @Autowired
    BikeRepository bikeRepository;


    public void createBike(BikeDTO bikeDTO) {
        Bike bike = new Bike();
        bike.setName(bikeDTO.getBikeName());
        bike.setType(bikeDTO.getBikeType());
        bike.setSize(bikeDTO.getBikeSize());
        bike.setStatus("AVAILABLE");
        bike.setNextAvailabilityDate(bikeDTO.getBikeNextAvailabilityDate());

        bikeRepository.save(bike);
    }

    public void removeBike(UUID bikeId) {
        bikeRepository.findById(bikeId).ifPresent(bike -> bikeRepository.delete(bike));
    }

    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    public void bookBike(BookDTO bookDTO) {
        bikeRepository.findById(bookDTO.getBikeId()).ifPresent(bike -> {
            if("AVAILABLE".equals(bike.getStatus()) && bike.getNextAvailabilityDate().isBefore(LocalDateTime.now())) {
                bike.setStatus("BOOKED");
                bike.setNextAvailabilityDate(bookDTO.getEndOfRentalDate());
                bikeRepository.saveAndFlush(bike);
            }
        });
    }

    public void updateBike(ChangeBikeDTO changeBikeDTO) {
        if(changeBikeDTO.getRentalDate().isAfter(LocalDateTime.now())) {
            Bike currentBike = bikeRepository.findById(changeBikeDTO.getCurrentBikeId()).orElse(null);
            Bike newBike = bikeRepository.findById(changeBikeDTO.getNewBikeId()).orElse(null);
            if("AVAILABLE".equals(newBike.getStatus()) && newBike.getNextAvailabilityDate().isBefore(LocalDateTime.now())) {
                newBike.setStatus("BOOKED");
                newBike.setNextAvailabilityDate(changeBikeDTO.getEndOfRentalDate());
                bikeRepository.saveAndFlush(newBike);
                currentBike.setStatus("AVAILABLE");
                currentBike.setNextAvailabilityDate(LocalDateTime.now());
                bikeRepository.saveAndFlush(currentBike);
            }
        }

    }
}
