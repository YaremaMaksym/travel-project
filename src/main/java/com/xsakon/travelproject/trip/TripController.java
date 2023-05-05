package com.xsakon.travelproject.trip;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping(params = "country")
    public List<Trip> getTripsByCountry(@RequestParam("country") String country) {
        return tripService.getAllTripsByCountry(country);
    }

    @GetMapping(params = "city")
    public List<Trip> getTripsByCity(@RequestParam("city") String city) {
        return tripService.getAllTripsByCity(city);
    }

//    @GetMapping("searchByPrice/{price}")
//    public List<Trip> getTripsByPrice(@PathVariable("price") BigDecimal price) {
//        return tripService.getAllTripsByPrice(price);
//    }


    @GetMapping(params = "maxPrice")
    public List<Trip> getTripsByPriceLessThan(@RequestParam("price") BigDecimal price) {
        return tripService.getAllTripsByPriceLessThan(price);
    }

    @GetMapping(params = "minPrice")
    public List<Trip> getTripsByPriceGreaterThan(@RequestParam("minPrice") BigDecimal price) {
        return tripService.getAllTripsByPriceGreaterThan(price);
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Trip> getTripsByPriceBetween(@RequestParam("minPrice") BigDecimal minPrice,
                                             @RequestParam("maxPrice") BigDecimal maxPrice) {
        return tripService.getAllTripsByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping(params = "duration")
    public List<Trip> getTripsByDuration(@RequestParam("duration") Integer duration) {
        return tripService.getAllTripsByDuration(duration);
    }
}
