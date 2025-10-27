package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.dta.DtaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosDataService {

    private final  PosDataRepository posDataRepository;

    private final PosDataMapper posDataMapper;

    private final DtaRepository dtaRepository;

    public PosDataService(PosDataRepository posDataRepository, PosDataMapper posDataMapper, DtaRepository dtaRepository) {
        this.posDataRepository = posDataRepository;
        this.posDataMapper = posDataMapper;
        this.dtaRepository = dtaRepository;
    }

    public PosDataResponseDto save(PosDataDto posDataDto) {
        var dta = dtaRepository.findById(posDataDto.dtaId())
                .orElseThrow(()-> new RuntimeException("Dta not found"));
        var posData = posDataMapper.toPosData(posDataDto, dta);
        posDataRepository.save(posData);
        return posDataMapper.toPosDataResponseDto(posData);
    }

    public List<PosDataResponseDto> findAll() {
        return posDataRepository.findAll()
                .stream()
                .map(posDataMapper::toPosDataResponseDto)
                .toList();
    }

    public PosDataResponseDto findById(Integer id) {
        return posDataRepository.findById(id)
                .map(posDataMapper::toPosDataResponseDto)
                .orElse(null);
    }
}
