package com.xsakon.travelproject.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripDAO tripDAO;

    public List<Trip> getAllTrips() {
        return tripDAO.selectAllTrips();
    }

    public List<Trip> getAllTripsByCountry(String country) {
        return tripDAO.selectAllTripsByCountriesContaining(country);
    }

    public List<Trip> getAllTripsByCity(String city) {
        return tripDAO.selectAllTripsByCitiesContaining(city);
    }

//    public List<Trip> getAllTripsByPrice(BigDecimal price) {
//        return tripDAO.selectAllTripsByPrice(price);
//    }

    public List<Trip> getAllTripsByPriceLessThan(BigDecimal price) {
        return tripDAO.selectAllTripsByPriceLessThan(price);
    }

    public List<Trip> getAllTripsByPriceGreaterThan(BigDecimal price) {
        return tripDAO.selectAllTripsByPriceGreaterThan(price);
    }

    public List<Trip> getAllTripsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return tripDAO.selectAllTripsByPriceBetween(minPrice, maxPrice);
    }

    public List<Trip> getAllTripsByDuration(Integer duration) {
        return tripDAO.selectAllTripsByDuration(duration);
    }
}
