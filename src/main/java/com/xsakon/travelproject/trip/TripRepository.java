package com.xsakon.travelproject.trip;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    boolean existsTripById(Integer integer);
    List<Trip> findAllByCountry();
    List<Trip> findAllByCity();
    List<Trip> findAllByPrice();
    List<Trip> findAllByDuration();
}

