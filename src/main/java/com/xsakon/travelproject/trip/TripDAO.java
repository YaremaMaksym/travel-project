package com.xsakon.travelproject.trip;

import java.util.List;

public interface TripDAO {
    List<Trip> selectAllTrips();
    List<Trip> selectAllTripsByCountry();
    List<Trip> selectAllTripsByCity();
    List<Trip> selectAllTripsByPrice();
    List<Trip> selectAllTripsByDuration();
}
