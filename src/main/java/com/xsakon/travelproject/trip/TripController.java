package com.xsakon.travelproject.trip;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping
    public List<Trip> getTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping
    public List<Trip> getTripsByCountry() {
        return tripService.getAllTripsByCountry();
    }

    @GetMapping
    public List<Trip> getTripsByCity() {
        return tripService.getAllTripsByCity();
    }

    @GetMapping
    public List<Trip> getTripsByPrice() {
        return tripService.getAllTripsByPrice();
    }

    @GetMapping
    public List<Trip> getTripsByDuration() {
        return tripService.getAllTripsByDuration();
    }
}
