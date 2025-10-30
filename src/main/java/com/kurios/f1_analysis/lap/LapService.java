package com.kurios.f1_analysis.lap;

import com.kurios.f1_analysis.compound.CompoundRepository;
import com.kurios.f1_analysis.dta.DtaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapService {

    private final LapMapper lapMapper;

    private final LapRepository lapRepository;

    private final DtaRepository dtaRepository;

    private final CompoundRepository compoundRepository;

    public LapService(LapMapper lapMapper, LapRepository lapRepository, DtaRepository dtaRepository, CompoundRepository compoundRepository) {
        this.lapMapper = lapMapper;
        this.lapRepository = lapRepository;
        this.dtaRepository = dtaRepository;
        this.compoundRepository = compoundRepository;
    }

    public LapResponseDto save(LapDto lapDto) {
        var dta = dtaRepository.findById(lapDto.dtaId())
                .orElseThrow(() -> new RuntimeException("DriverTeamAssignment not found"));
        var compound = compoundRepository.findById(lapDto.compoundId())
                .orElseThrow(() -> new RuntimeException("Compound not found"));
        var lap = lapMapper.toLap(lapDto, dta, compound);
        lapRepository.save(lap);
        return  lapMapper.toLapResponseDto(lap);
    }

    public List<LapResponseDto> findAll() {
        return lapRepository.findAll()
                .stream()
                .map(lapMapper::toLapResponseDto)
                .toList();
    }

    public LapResponseDto findById(Integer id) {
        return lapRepository.findById(id)
                .map(lapMapper::toLapResponseDto)
                .orElse(null);
    }

    public List<LapResponseDto> findAllByDtaId(Integer dtaId) {
        return lapRepository.findAllByDta_Id(dtaId)
                .stream()
                .map(lapMapper::toLapResponseDto)
                .toList();
    }

    public List<LapAllDriverDataDto> findAllDriverLapInfo(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber) {
        return lapRepository.findAllDriverLapInfo(year, roundNumber, sessionNameId, lapNumber);
    }

    public List<LapDriverDataLastTenDto> findLastTenLapPerDriver(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber, Short driverNumber) {
        return lapRepository.findLastTenLapPerDriver(year, roundNumber, sessionNameId, lapNumber, driverNumber);
    }

    public List<LapDriverDataSectorDto> findFastestSector(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber, Short sectorNumber) {
        return lapRepository.findFastestSector(year, roundNumber, sessionNameId, lapNumber, sectorNumber);
    }

    public List<LapDriverDataLapDto> findFastestLap(Integer year, Integer roundNumber, Integer sessionNameId, Short lapNumber) {
        return lapRepository.findFastestLap(year, roundNumber, sessionNameId, lapNumber);
    }

    public List<LapDriverDataTheoraticalLapDto> findTheoraticalFastestLap(Integer year, Integer roundNumber, Integer sessionNameId,  Short lapNumber) {
        return lapRepository.findTheoraticalFastestLap(year, roundNumber, sessionNameId, lapNumber);
    }
}
