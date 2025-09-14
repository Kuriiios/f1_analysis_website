package com.kurios.f1_analysis.driver_team_assignment;

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
public class DriverTeamAssignmentController {

    private final DriverTeamAssignmentService driverTeamAssignmentService;

    public DriverTeamAssignmentController(DriverTeamAssignmentService driverTeamAssignmentService) {
        this.driverTeamAssignmentService = driverTeamAssignmentService;
    }

    @PostMapping("")
    public DriverTeamAssignment create(@Valid @RequestBody DriverTeamAssignmentDto driverTeamAssignmentDto) {
        return driverTeamAssignmentService.save(driverTeamAssignmentDto);
    }

    @GetMapping("")
    public List<DriverTeamAssignmentResponseDto>  findAll() {
        return driverTeamAssignmentService.findAll();
    }

    @GetMapping("/{id}")
    public DriverTeamAssignmentResponseDto findById(@PathVariable Integer id) {
        return driverTeamAssignmentService.findById(id);
    }

    @GetMapping("/by-session/{sessionId}")
    public List<DriverTeamAssignmentResponseDto> findBySessionId(@PathVariable Integer sessionId) {
        return driverTeamAssignmentService.findAllBySessionId(sessionId);
    }

    @GetMapping("/by-driver/{driverId}")
    public List<DriverTeamAssignmentResponseDto> findByDriverId(@PathVariable Integer driverId) {
        return driverTeamAssignmentService.findAllByDriverId(driverId);
    }

    @GetMapping("/by-team/{teamId}")
    public List<DriverTeamAssignmentResponseDto> findByTeamId(@PathVariable Integer teamId) {
        return driverTeamAssignmentService.findAllByTeamId(teamId);
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
