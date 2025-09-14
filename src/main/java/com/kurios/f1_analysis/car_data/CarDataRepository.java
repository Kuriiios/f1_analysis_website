package com.kurios.f1_analysis.car_data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDataRepository extends JpaRepository<CarData, Integer> {

    List<CarData> findAllByCarDataLap_Id(Integer lapId);
}
