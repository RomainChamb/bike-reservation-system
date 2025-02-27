package com.barbebroux.bikereservationsystem.dto;

import com.barbebroux.bikereservationsystem.controller.RiderController;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ChangeBikeDTO {

    private final UUID currentBikeId;
    private final UUID newBikeId;
    private final LocalDateTime rentalDate;
    private final LocalDateTime endOfRentalDate;

    public ChangeBikeDTO(RiderController.ChangeBikeRequest changeBikeRequest) {
        this.currentBikeId = changeBikeRequest.currentBikeID();
        this.newBikeId = changeBikeRequest.newBikeID();
        this.rentalDate = changeBikeRequest.rentalDate();
        this.endOfRentalDate = changeBikeRequest.endOfRentalDate();
    }
}
