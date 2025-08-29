package com.kurios.f1_analysis.driver;

import org.springframework.stereotype.Service;

@Service
public class DriverMapper {

    public Driver toDriver(DriverDto driverDto) {
        return new Driver(
                driverDto.driverNumber(),
                driverDto.driverAbbreviation(),
                driverDto.driverName(),
                driverDto.driverHexColor(),
                driverDto.country()
        );
    }

    public  DriverResponseDto toDriverResponseDto(Driver driver) {
        return new DriverResponseDto(
                driver.getDriverNumber(),
                driver.getDriverAbbreviation(),
                driver.getDriverName()
        );
    }
}
