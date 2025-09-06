package com.kurios.f1_analysis.pos_data;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/pos-data")
public class PosDataController {

    private final PosDataService posDataService;

    public PosDataController(PosDataService posDataService) {
        this.posDataService = posDataService;
    }

    @PostMapping("")
    public PosDataResponseDto create(@Valid @RequestBody PosDataDto posDataDto) {
        return posDataService.save(posDataDto);
    }

    @GetMapping("")
    public List<PosDataResponseDto> findAll() {
        return posDataService.findAll();
    }

    @GetMapping("/{id}")
    public PosDataResponseDto findById(@PathVariable Integer id) {
        return posDataService.findById(id);
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
