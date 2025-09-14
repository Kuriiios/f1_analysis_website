package com.kurios.f1_analysis.session_name;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/session-name")
public class SessionNameController {

    private final SessionNameService sessionNameService;

    public SessionNameController(SessionNameService sessionNameService) {
        this.sessionNameService = sessionNameService;
    }

    @GetMapping
    public List<SessionNameResponseDto> findAll() {
        return sessionNameService.findAll();
    }

    @GetMapping("/{id}")
    public SessionNameResponseDto findById(@PathVariable Integer id) {
        return sessionNameService.findById(id);
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
