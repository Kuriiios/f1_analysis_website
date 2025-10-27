package com.kurios.f1_analysis.event_session;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EventSessionController {

    private final EventSessionService eventSessionService;

    public EventSessionController(EventSessionService eventSessionService) {
        this.eventSessionService = eventSessionService;
    }

    @GetMapping("/sessions")
    public List<EventSessionResponseDto> findAll() {
        return eventSessionService.findAll();
    }

    @GetMapping("/sessions/{id}")
    public EventSessionResponseDto findById(@PathVariable Integer id) {
        return eventSessionService.findById(id);
    }

    @PostMapping("/sessions/{year}")
    public ResponseEntity<String> importAllSessions(@PathVariable Integer year) {
        eventSessionService.saveAllSessions(year);
        return ResponseEntity.ok().body("Succesfully imported all data from fastF1 to database.");
    }

    @PostMapping("/session/{year}/{roundNumber}")
    public ResponseEntity<String> importSession(@PathVariable Integer year,
                                                 @PathVariable Short roundNumber) {
        eventSessionService.saveSessionForRoundNumber(year, roundNumber);
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
