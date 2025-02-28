package com.barbebroux.bikereservationsystem.controller;

import com.barbebroux.bikereservationsystem.dto.BookDTO;
import com.barbebroux.bikereservationsystem.entity.Bike;
import com.barbebroux.bikereservationsystem.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/")
    public String showAvailableBikes(Model model) {
        List<Bike> bikes = bikeService.getAllBikes();  // Assume this method fetches all bikes
        model.addAttribute("bikes", bikes);
        return "index";
    }

    @GetMapping("/booking")
    public String showReservationForm(Model model, @RequestParam("id") UUID bikeId) {
        Bike bike = bikeService.getBikeById(bikeId);
        model.addAttribute("bike", bike);
        return "booking";
    }

    @PostMapping("/book")
    public String makeReservation(@RequestParam("bikeId") UUID bikeId, @RequestParam("rentalDate") LocalDateTime rentalDate, @RequestParam("endOfRentalDate") LocalDateTime endOfRentalDate,
                                  @RequestParam("zipCode") String zipCode) {
        BookDTO bookDTO = new BookDTO(bikeId, rentalDate, endOfRentalDate, zipCode);
        bikeService.bookBike(bookDTO);
        return "redirect:/";
    }



}
