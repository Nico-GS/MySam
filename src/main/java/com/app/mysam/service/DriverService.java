package com.app.mysam.service;

import com.app.mysam.model.Driver;
import com.app.mysam.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public void createDriver (Driver driver) {
        driverRepository.save(driver);
    }


}
