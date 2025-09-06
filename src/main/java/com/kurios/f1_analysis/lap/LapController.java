package com.kurios.f1_analysis.lap;

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
@RequestMapping("/lap")
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
