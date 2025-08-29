package com.kurios.f1_analysis.driver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/driver")
    public DriverResponseDto create(@RequestBody DriverDto driverDto) {
        return driverService.create(driverDto);
    }

    @GetMapping("/driver")
    public List<DriverResponseDto> findAll() {
        return driverService.findAll();
    }
}
