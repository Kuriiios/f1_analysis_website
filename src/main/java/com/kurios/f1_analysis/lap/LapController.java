package com.kurios.f1_analysis.lap;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/laps")
public class LapController {

    private LapService lapService;

    public LapController(LapService lapService) {
        this.lapService = lapService;
    }

    @PostMapping("")
    public LapResponseDto create(@Valid @RequestBody LapDto lapDto) {
        return lapService.save(lapDto);
    }

    @GetMapping("")
    public List<LapResponseDto> findAll() {
        return lapService.findAll();
    }

    @GetMapping("/{id}")
    public LapResponseDto findById(@PathVariable Integer id) {
        return lapService.findById(id);
    }

    @GetMapping("/by-dta/{dtaId}")
    public List<LapResponseDto> findByDtaId(@PathVariable Integer dtaId) {
        return lapService.findAllByDtaId(dtaId);
    }

    @GetMapping("/all-driver-info")
    public List<LapAllDriverDataDto> findAllDriverLapInfo(
            @RequestParam("year") Integer year,
            @RequestParam("roundNumber") Integer roundNumber,
            @RequestParam("sessionNameId") Integer sessionNameId,
            @RequestParam("lapNumber") Short lapNumber) {
        return lapService.findAllDriverLapInfo(year, roundNumber, sessionNameId, lapNumber);
    }

    @GetMapping("/per-driver-info")
    public List<LapDriverDataLastTenDto> findLastTenLapPerDriver(
            @RequestParam("year") Integer year,
            @RequestParam("roundNumber") Integer roundNumber,
            @RequestParam("sessionNameId") Integer sessionNameId,
            @RequestParam("lapNumber") Short lapNumber,
            @RequestParam("driverNumber") Short driverNumber) {
        return lapService.findLastTenLapPerDriver(year, roundNumber, sessionNameId, lapNumber, driverNumber);
    }

    @GetMapping("/best-sector")
    public List<LapDriverDataSectorDto> findFastestSector(
            @RequestParam("year") Integer year,
            @RequestParam("roundNumber") Integer roundNumber,
            @RequestParam("sessionNameId") Integer sessionNameId,
            @RequestParam("lapNumber") Short lapNumber,
            @RequestParam("sectorNumber") Short sectorNumber) {
        return lapService.findFastestSector(year, roundNumber, sessionNameId, lapNumber, sectorNumber);
    }

    @GetMapping("/best-lap")
    public List<LapDriverDataLapDto> findFastestLap(
            @RequestParam("year") Integer year,
            @RequestParam("roundNumber") Integer roundNumber,
            @RequestParam("sessionNameId") Integer sessionNameId,
            @RequestParam("lapNumber") Short lapNumber) {
        return lapService.findFastestLap(year, roundNumber, sessionNameId, lapNumber);
    }

    @GetMapping("/theoratical-best-lap")
    public List<LapDriverDataTheoraticalLapDto> findTheoraticalFastestLap(
            @RequestParam("year") Integer year,
            @RequestParam("roundNumber") Integer roundNumber,
            @RequestParam("sessionNameId") Integer sessionNameId,
            @RequestParam("lapNumber") Short lapNumber) {
        return lapService.findTheoraticalFastestLap(year, roundNumber, sessionNameId, lapNumber);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        var errors =  new HashMap<String, String>();
        e.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
