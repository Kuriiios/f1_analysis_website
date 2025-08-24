package com.kurios.f1_analysis.drs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrsController {

    private final DrsRepository drsRepository;

    public DrsController(DrsRepository drsRepository) {
        this.drsRepository = drsRepository;
    }

    @PostMapping("/drs")
    public Drs create(@RequestBody Drs drs) {
        return drsRepository.save(drs);
    }

    @GetMapping("/drs")
    public List<Drs> findAll() {
        return drsRepository.findAll();
    }
}
