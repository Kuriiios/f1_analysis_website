package com.kurios.f1_analysis.event_round;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/event-rounds")
public class EventRoundController {

    private final EventRoundService eventRoundService;

    public EventRoundController(EventRoundService eventRoundService) {
        this.eventRoundService = eventRoundService;
    }

    @GetMapping("")
    public List<EventRoundResponseDto> findAll() {
        return eventRoundService.findAll();
    }

    @GetMapping("/{id}")
    public EventRoundResponseDto findById(@PathVariable Integer id) {
        return eventRoundService.findById(id);
    }

    @GetMapping("/by-round/{roundNumber}")
    public EventRoundResponseDto findByRoundNumber(@PathVariable Short roundNumber) {
        return eventRoundService.findAllByRoundNumber(roundNumber);
    }

    @PostMapping("/{year}")
    public ResponseEntity<String> importSeason(@PathVariable Integer year) {
        eventRoundService.saveRacesForSeason(year);
        return ResponseEntity.ok().body("Succesfully imported data from fastF1 to database.");
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
