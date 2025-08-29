package com.kurios.f1_analysis.car_data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarDataController {

    private final CarDataService carDataService;

    public CarDataController(CarDataService carDataService) {
        this.carDataService = carDataService;
    }

    @PostMapping("/car-data")
    public CarDataResponseDto create(@RequestBody CarDataDto carDataDto) {
        return carDataService.create(carDataDto);
    }

    @GetMapping("/car-data")
    public List<CarDataResponseDto> findAll() {
        return carDataService.findAll();
    }
}
