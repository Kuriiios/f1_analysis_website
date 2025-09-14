package com.kurios.f1_analysis.session;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/sessions")
    public List<SessionResponseDto> findAll() {
        return sessionService.findAll();
    }

    @GetMapping("/sessions/{id}")
    public SessionResponseDto findById(@PathVariable Integer id) {
        return sessionService.findById(id);
    }

    @PostMapping("/sessions/{year}")
    public ResponseEntity<String> importAllSessions(@PathVariable Integer year) {
        sessionService.saveAllSessions(year);
        return ResponseEntity.ok().body("Succesfully imported all data from fastF1 to database.");
    }

    @PostMapping("/session/{year}/{roundNumber}")
    public ResponseEntity<String> importSession(@PathVariable Integer year,
                                                 @PathVariable Short roundNumber) {
        sessionService.saveSessionForRoundNumber(year, roundNumber);
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
