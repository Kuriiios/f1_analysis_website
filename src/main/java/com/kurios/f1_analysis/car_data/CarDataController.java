package com.kurios.f1_analysis.car_data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarDataController {
    private final CarDataRepository carDataRepository;

    public CarDataController(CarDataRepository carDataRepository) {
        this.carDataRepository = carDataRepository;
    }

    @PostMapping("/car-data")
    public CarData create(@RequestBody CarData carData) {
        return carDataRepository.save(carData);
    }

    @GetMapping("/car-data")
    public List<CarData> findAll() {
        return carDataRepository.findAll();
    }
}
