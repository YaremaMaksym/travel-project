package com.xsakon.travelproject.trip;

import java.math.BigDecimal;
import java.util.List;

public interface TripDAO {
    List<Trip> selectAllTrips();
    List<Trip> selectAllTripsByCountriesContaining(String country);
    List<Trip> selectAllTripsByCitiesContaining(String city);
//    List<Trip> selectAllTripsByPrice(BigDecimal price);
    List<Trip> selectAllTripsByPriceLessThan(BigDecimal price);
    List<Trip> selectAllTripsByPriceGreaterThan(BigDecimal price);
    List<Trip> selectAllTripsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Trip> selectAllTripsByDuration(Integer duration);
}
