package com.barbebroux.bikereservationsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Bike {

    @Id
    private UUID id;

    private String name;

    private String type;

    private String status;

    private String size;

    private LocalDateTime nextAvailabilityDate;

    @PrePersist
    public void generateUUID() {
        if(id == null) {
            id = UUID.randomUUID();
        }
    }
}
