package com.kurios.f1_analysis.car_data;

import com.kurios.f1_analysis.dta.DtaRepository;
import com.kurios.f1_analysis.drs.DrsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDataService {

    private final DtaRepository dtaRepository;

    private final DrsRepository drsRepository;

    private CarDataRepository carDataRepository;

    private CarDataMapper carDataMapper;

    public CarDataService(CarDataMapper carDataMapper, CarDataRepository carDataRepository, DtaRepository dtaRepository, DrsRepository drsRepository) {
        this.carDataMapper = carDataMapper;
        this.carDataRepository = carDataRepository;
        this.dtaRepository = dtaRepository;
        this.drsRepository = drsRepository;
    }

    public CarDataResponseDto save(CarDataDto carDataDto) {
        var dta = dtaRepository.findById(carDataDto.dtaId())
                .orElseThrow(()-> new RuntimeException("Dta not found"));
        var drs = drsRepository.findById(carDataDto.drsId())
                .orElseThrow(()-> new RuntimeException("Drs not found"));
        var carData = carDataMapper.toCarData(carDataDto, dta, drs);
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

    public CarDataResponseDto findById(Integer id) {
        return carDataRepository.findById(id)
                .map(carDataMapper::toCarDataResponseDto)
                .orElse(null);
    }

    public List<CarDataResponseDto> findAllByDtaId(Integer dtaId) {
        return carDataRepository.findAllByCarDataDta_Id(dtaId)
                .stream()
                .map(carDataMapper::toCarDataResponseDto)
                .toList();
    }
}
