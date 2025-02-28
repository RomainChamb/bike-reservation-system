package com.barbebroux.bikereservationsystem.dto;

import com.barbebroux.bikereservationsystem.controller.RiderController;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class BookDTO {

    private final UUID bikeId;
    private final LocalDateTime rentalDate;
    private final LocalDateTime endOfRentalDate;
    private final String zipCode;

    public BookDTO(RiderController.BookRequest bookRequest) {
        this.bikeId = bookRequest.bikeId();
        this.rentalDate = bookRequest.rentalDate();
        this.endOfRentalDate = bookRequest.endOfRentalDate();
        this.zipCode = bookRequest.zipCode();
    }

    public BookDTO(UUID bikeId, LocalDateTime rentalDate, LocalDateTime endOfRentalDate, String zipCode) {
        this.bikeId = bikeId;
        this.rentalDate = rentalDate;
        this.endOfRentalDate = endOfRentalDate;
        this.zipCode = zipCode;
    }
}
