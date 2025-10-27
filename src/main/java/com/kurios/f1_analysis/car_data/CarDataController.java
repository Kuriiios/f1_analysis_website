package com.kurios.f1_analysis.car_data;

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
@RequestMapping("/car-data")
public class CarDataController {

    private final CarDataService carDataService;

    public CarDataController(CarDataService carDataService) {
        this.carDataService = carDataService;
    }

    @PostMapping("")
    public CarDataResponseDto create(@Valid @RequestBody CarDataDto carDataDto) {
        return carDataService.save(carDataDto);
    }

    @GetMapping("")
    public List<CarDataResponseDto> findAll() {
        return carDataService.findAll();
    }


    @GetMapping("/{id}")
    public CarDataResponseDto findById(@PathVariable Integer id) {
        return carDataService.findById(id);
    }

    @GetMapping("/by-dta/{dtaId}")
    public List<CarDataResponseDto> findAllByDtaId(@PathVariable Integer dtaId) {
        return carDataService.findAllByDtaId(dtaId);
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
