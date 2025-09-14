package com.kurios.f1_analysis.compound;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompoundService {

    private final CompoundRepository compoundRepository;

    private final CompoundMapper compoundMapper;

    public CompoundService(CompoundRepository compoundRepository, CompoundMapper compoundMapper) {
        this.compoundRepository = compoundRepository;
        this.compoundMapper = compoundMapper;
    }

    public List<CompoundResponseDto> findAll() {
        return compoundRepository.findAll()
                .stream()
                .map(compoundMapper::toCompoundResponseDto)
                .collect(Collectors.toList());
    }

    public CompoundResponseDto findById(Integer id) {
        return compoundRepository.findById(id)
                .map(compoundMapper::toCompoundResponseDto)
                .orElse(null);
    }
}
