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

    public BookDTO(RiderController.BookRequest bookRequest) {
        this.bikeId = bookRequest.bikeId();
        this.rentalDate = bookRequest.rentalDate();
        this.endOfRentalDate = bookRequest.endOfRentalDate();
    }
}
