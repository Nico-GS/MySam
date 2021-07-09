package com.app.mysam.controller;

import com.app.mysam.model.Trip;
import com.app.mysam.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TripController {

    private final Logger LOGGER = LoggerFactory.getLogger(TripController.class);

    @Autowired
    private TripService tripService;

    /**
     * Create a new Trip, customer lastname, firstname & phone are mandatory
     * @param trip to create
     */
    @PostMapping("/createTrip")
    public void createTrip(@RequestBody @Validated Trip trip) {
        LOGGER.info("Create Trip OK");
        tripService.createTrip(trip);
    }

    /**
     * Accept a trip by driver
     * @param tripId the trip ID in parameters
     * @param driverId the driver ID in Header
     */
    @PostMapping("/acceptTrip")
    public void acceptTrip(@RequestParam String tripId, @RequestHeader String driverId) {
        LOGGER.info("Trip accepted : " + tripId + " with driver ID : " + driverId);
        tripService.acceptTrip(tripId, driverId);
    }

    /**
     * Start a trip
     * @param tripId the trip ID in paramaters
     */
    @PostMapping("/startTrip")
    public void startTrip(@RequestParam String tripId) {
        LOGGER.info("Trip started : " + tripId);
        tripService.startTrip(tripId);
    }

    /**
     * End a trip
     * @param tripId the trip ID in parameters
     */
    @PostMapping("/endTrip")
    public void endTrip(@RequestParam String tripId) {
        LOGGER.info("Trip finished : " + tripId);
        tripService.endTrip(tripId);
    }




}
