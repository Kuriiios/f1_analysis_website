package com.kurios.f1_analysis.dta;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/dta")
public class DtaController {

    private final DtaService dtaService;

    public DtaController(DtaService dtaService) {
        this.dtaService = dtaService;
    }

    @PostMapping("")
    public Dta create(@Valid @RequestBody DtaDto dtaDto) {
        return dtaService.save(dtaDto);
    }

    @GetMapping("")
    public List<DtaResponseDto>  findAll() {
        return dtaService.findAll();
    }

    @GetMapping("/{id}")
    public DtaResponseDto findById(@PathVariable Integer id) {
        return dtaService.findById(id);
    }

    @GetMapping("/by-session/{sessionId}")
    public List<DtaResponseDto> findBySessionId(@PathVariable Integer sessionId) {
        return dtaService.findAllBySessionId(sessionId);
    }

    @GetMapping("/by-driver/{driverId}")
    public List<DtaResponseDto> findByDriverId(@PathVariable Integer driverId) {
        return dtaService.findAllByDriverId(driverId);
    }

    @GetMapping("/by-team/{teamId}")
    public List<DtaResponseDto> findByTeamId(@PathVariable Integer teamId) {
        return dtaService.findAllByTeamId(teamId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        var errors = new HashMap<String, String>();
        e.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
