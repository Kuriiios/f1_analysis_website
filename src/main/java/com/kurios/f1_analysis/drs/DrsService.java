package com.kurios.f1_analysis.drs;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrsService {

    private final DrsRepository drsRepository;

    private final DrsMapper drsMapper;

    public DrsService(DrsRepository drsRepository, DrsMapper drsMapper) {
        this.drsRepository = drsRepository;
        this.drsMapper = drsMapper;
    }

    public List<DrsResponseDto> findAll() {
        return drsRepository.findAll()
                .stream()
                .map(drsMapper::toDrsResponseDto)
                .toList();
    }
}
