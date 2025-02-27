package com.barbebroux.bikereservationsystem.dto;

import com.barbebroux.bikereservationsystem.controller.AdminController;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class BikeDTO {

    private final UUID bikeId;
    private final String bikeName;
    private final String bikeType;
    private final String bikeStatus;
    private final String bikeSize;
    private final LocalDateTime bikeNextAvailabilityDate;

    public BikeDTO(AdminController.BikeRequest bikeRequest) {
        this.bikeId = null;
        this.bikeName = bikeRequest.bikeName();
        this.bikeType = bikeRequest.bikeType();
        this.bikeStatus = null;
        this.bikeSize = bikeRequest.bikeSize();
        this.bikeNextAvailabilityDate = bikeRequest.bikeNextAvailabilityDate();
    }
}
