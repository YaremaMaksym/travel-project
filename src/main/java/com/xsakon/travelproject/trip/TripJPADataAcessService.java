package com.xsakon.travelproject.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("jpa")
@RequiredArgsConstructor
public class TripJPADataAcessService implements TripDAO{
    private final TripRepository tripRepository;

    @Override
    public List<Trip> selectAllTrips(){
        return tripRepository.findAll();
    }
    @Override
    public List<Trip> selectAllTripsByCountry(){
        return tripRepository.findAllByCountry();
    }
    @Override
    public List<Trip> selectAllTripsByCity() {
        return tripRepository.findAllByCity();
    }
    @Override
    public List<Trip> selectAllTripsByPrice(){
        return tripRepository.findAllByPrice();
    }
    @Override
    public List<Trip> selectAllTripsByDuration() {
        return tripRepository.findAllByDuration();
    }

}
