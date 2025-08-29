package com.kurios.f1_analysis.compound;

import org.springframework.stereotype.Service;

@Service
public class CompoundMapper {

    public CompoundResponseDto toCompoundResponseDto(Compound compound) {
        return new CompoundResponseDto(
                compound.getId(),
                compound.getCompoundName()
        );
    }
}
