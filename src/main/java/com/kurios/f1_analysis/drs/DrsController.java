package com.kurios.f1_analysis.drs;

import com.kurios.f1_analysis.event_round.EventRoundResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drs")
public class DrsController {

    private final DrsService drsService;

    public DrsController(DrsService drsService) {
        this.drsService = drsService;
    }

    @GetMapping("")
    public List<DrsResponseDto> findAll() {
        return drsService.findAll();
    }

    @GetMapping("/{id}")
    public DrsResponseDto findById(@PathVariable Integer id) {
        return drsService.findById(id);
    }

}
