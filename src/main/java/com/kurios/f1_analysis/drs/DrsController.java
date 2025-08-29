package com.kurios.f1_analysis.drs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrsController {

    private final DrsService drsService;

    public DrsController(DrsService drsService) {
        this.drsService = drsService;
    }

    @GetMapping("/drs")
    public List<DrsResponseDto> findAll() {
        return drsService.findAll();
    }
}
