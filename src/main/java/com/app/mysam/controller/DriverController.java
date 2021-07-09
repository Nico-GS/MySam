package com.app.mysam.controller;

import com.app.mysam.model.Driver;
import com.app.mysam.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class DriverController {

    @Autowired
    private DriverService driverService;

    /**
     * Create a new driver, LastName can't be blank
     * @param driver the driver to create
     */
    @PostMapping("createDriver")
    public void createDriver(@RequestBody @Validated Driver driver) {
        driverService.createDriver(driver);
    }

}
