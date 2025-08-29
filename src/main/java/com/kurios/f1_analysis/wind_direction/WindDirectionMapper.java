package com.kurios.f1_analysis.wind_direction;

import org.springframework.stereotype.Service;

@Service
public class WindDirectionMapper {

    public WindDirectionResponseDto toWindDirectionResponseDto(WindDirection windDirection) {
        return new WindDirectionResponseDto(
                windDirection.getId(),
                windDirection.getCardinalDirection()
        );
    }
}
