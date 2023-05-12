package com.xsakon.travelproject.trip;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findByCountriesContainingIgnoreCase(String country);
    List<Trip> findByCitiesContainingIgnoreCase(String city);
    //List<Trip> findByPrice(BigDecimal price);
    List<Trip> findByPriceLessThan(BigDecimal price);
    List<Trip> findByPriceGreaterThan(BigDecimal price);
    List<Trip> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    List<Trip> findByDuration(Integer duration);
}

