package com.kurios.f1_analysis.driver;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public DriverResponseDto create(DriverDto driverDto) {
        var driver = driverMapper.toDriver(driverDto);
        var savedDriver = driverRepository.save(driver);
        var driverResponseDto = driverMapper.toDriverResponseDto(savedDriver);
        return driverResponseDto;
    }

    public List<DriverResponseDto> findAll() {
        return driverRepository.findAll()
                .stream()
                .map(driverMapper::toDriverResponseDto)
                .collect(Collectors.toList());
    }
}
