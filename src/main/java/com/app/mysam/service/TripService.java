package com.app.mysam.service;

import com.app.mysam.model.Driver;
import com.app.mysam.model.Trip;
import com.app.mysam.model.TripState;
import com.app.mysam.repository.CustomerRepository;
import com.app.mysam.repository.DriverRepository;
import com.app.mysam.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private final double PRICE_TRIP = 20.00;

    /**
     * Create a new trip
     *
     * @param trip the trip to create
     */
    public void createTrip(Trip trip) {
        Trip tripToCreate = new Trip();
        tripToCreate.setCustomerFirstName(trip.getCustomerFirstName());
        tripToCreate.setCustomerLastName(trip.getCustomerLastName());
        tripToCreate.setCustomerPhone(trip.getCustomerPhone());
        tripToCreate.setState(TripState.WAITING_FOR_DRIVER);
        tripToCreate.setPrice(PRICE_TRIP);
        tripRepository.save(tripToCreate);
    }

    /**
     * Accept a trip by driver
     *
     * @param tripId   the trip ID in String
     * @param driverId the driverID in String
     */
    public void acceptTrip(String tripId, String driverId) {
        Optional<Trip> tripToAccept = tripRepository.findById(tripId);
        Optional<Driver> driver = driverRepository.findById(driverId);
        if (tripToAccept.isPresent() && driver.isPresent()) {
            Trip trip = tripToAccept.get();
            Driver driver2 = driver.get();
            driver2.setTripId(tripId);
            trip.setDriverId(driver2.getId());
            trip.setState(TripState.ASSIGNED_TO_DRIVER);
            driverRepository.save(driver2);
            tripRepository.save(trip);
        }
    }

    /**
     * Start Trip, assign a date and time, and status in progress
     *
     * @param tripId the trip ID in String
     */
    public void startTrip(String tripId) {
        Optional<Trip> tripToStart = tripRepository.findById(tripId);
        Trip trip = tripToStart.get();
        trip.setStartTrip(LocalDateTime.now());
        trip.setState(TripState.TRIP_IN_PROGRESS);
        tripRepository.save(trip);
    }

    /**
     * End the trip, assign a date and time, set price and status finish
     * Assign a price, debit customer et credit driver & MySam
     * @param tripId the trip ID in String
     */
    public void endTrip(String tripId) {
        Optional<Trip> tripToEnd = tripRepository.findById(tripId);
        if (tripToEnd.isPresent()) {
            Trip trip = tripToEnd.get();
            trip.setEndTrip(LocalDateTime.now());
            trip.setState(TripState.TRIP_FINISH);
            trip.setDebitCustomer(PRICE_TRIP);
            trip.setCreditDriver(PRICE_TRIP * 0.85);
            trip.setCreditMySam(PRICE_TRIP * 0.15);
            tripRepository.save(trip);
        }
    }

}
