package com.xsakon.travelproject.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripDAO tripDAO;

    public List<Trip> getAllTrips() {
        return tripDAO.selectAllTrips();
    }

    public List<Trip> getAllTripsByCountry() {
        return tripDAO.selectAllTripsByCountry();
    }

    public List<Trip> getAllTripsByCity() {
        return tripDAO.selectAllTripsByCity();
    }

    public List<Trip> getAllTripsByPrice() {
        return tripDAO.selectAllTripsByPrice();
    }

    public List<Trip> getAllTripsByDuration() {
        return tripDAO.selectAllTripsByDuration();
    }
}
