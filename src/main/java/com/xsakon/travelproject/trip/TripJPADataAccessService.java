package com.xsakon.travelproject.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TripJPADataAccessService implements TripDAO{
    private final TripRepository tripRepository;

    @Override
    public List<Trip> selectAllTrips(){
        return tripRepository.findAll();
    }
    @Override
    public List<Trip> selectAllTripsByCountriesContaining(String country){
        return tripRepository.findByCountriesContainingIgnoreCase(country);
    }
    @Override
    public List<Trip> selectAllTripsByCitiesContaining(String city){
        return tripRepository.findByCitiesContainingIgnoreCase(city);
    }
//    @Override
//    public List<Trip> selectAllTripsByPrice(BigDecimal price){
//        return tripRepository.findByPrice(price);
//    }

    @Override
    public List<Trip> selectAllTripsByPriceLessThan(BigDecimal price){
        return tripRepository.findByPriceLessThan(price);
    }
    @Override
    public List<Trip> selectAllTripsByPriceGreaterThan(BigDecimal price) {
        return tripRepository.findByPriceGreaterThan(price);
    }
    @Override
    public List<Trip> selectAllTripsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice){
        return tripRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Trip> selectAllTripsByDuration(Integer duration) {
        return tripRepository.findByDuration(duration);
    }

}
