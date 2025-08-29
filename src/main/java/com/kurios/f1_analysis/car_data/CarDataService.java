package com.kurios.f1_analysis.car_data;

import com.kurios.f1_analysis.drs.DrsRepository;
import com.kurios.f1_analysis.lap.LapRepository;
import com.kurios.f1_analysis.track_status.TrackStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDataService {

    private final LapRepository lapRepository;

    private final DrsRepository drsRepository;

    private final TrackStatusRepository trackStatusRepository;

    private CarDataRepository carDataRepository;

    private CarDataMapper carDataMapper;

    public CarDataService(CarDataMapper carDataMapper, CarDataRepository carDataRepository, LapRepository lapRepository, DrsRepository drsRepository, TrackStatusRepository trackStatusRepository) {
        this.carDataMapper = carDataMapper;
        this.carDataRepository = carDataRepository;
        this.lapRepository = lapRepository;
        this.drsRepository = drsRepository;
        this.trackStatusRepository = trackStatusRepository;
    }

    public CarDataResponseDto create(CarDataDto carDataDto) {
        var lap = lapRepository.findById(carDataDto.lapId())
                .orElseThrow(()-> new RuntimeException("Lap not found"));
        var drs = drsRepository.findById(carDataDto.drsId())
                .orElseThrow(()-> new RuntimeException("Drs not found"));
        var trackStatus = trackStatusRepository.findById(carDataDto.trackStatusId())
                .orElseThrow(() -> new RuntimeException("DriverTeamAssignment not found"));
        var carData = carDataMapper.toCarData(carDataDto, lap, drs, trackStatus);
        carDataRepository.save(carData);
        var carDataResponseDto = carDataMapper.toCarDataResponseDto(carData);
        return carDataResponseDto;
    }

    public List<CarDataResponseDto> findAll() {
        return carDataRepository.findAll()
                .stream()
                .map(carDataMapper::toCarDataResponseDto)
                .toList();
    }
}
