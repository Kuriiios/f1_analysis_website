package com.kurios.f1_analysis.drs;

import org.springframework.stereotype.Service;

@Service
public class DrsMapper {

    public DrsResponseDto toDrsResponseDto(Drs drs) {
        return new DrsResponseDto(
                drs.getId(),
                drs.getDrsState()
        );
    }
}
