package com.kurios.f1_analysis.driver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @PostMapping("/drivers")
    public Driver create(@RequestBody Driver driver) {
        return driverRepository.save(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }
}
