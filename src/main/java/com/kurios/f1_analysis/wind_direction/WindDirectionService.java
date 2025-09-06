package com.kurios.f1_analysis.wind_direction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WindDirectionService {

    public final WindDirectionRepository windDirectionRepository;
    public final WindDirectionMapper windDirectionMapper;

    public WindDirectionService(WindDirectionRepository windDirectionRepository, WindDirectionMapper windDirectionMapper) {
        this.windDirectionRepository = windDirectionRepository;
        this.windDirectionMapper = windDirectionMapper;
    }

    public List<WindDirectionResponseDto> findAll() {
        return windDirectionRepository.findAll()
                .stream()
                .map(windDirectionMapper::toWindDirectionResponseDto)
                .toList();
    }

    public WindDirectionResponseDto findById(Integer id) {
        return windDirectionRepository.findById(id)
                .map(windDirectionMapper::toWindDirectionResponseDto)
                .orElse(null);
    }
}
