package com.kurios.f1_analysis.compound;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompoundController {

    private final CompoundRepository compoundRepository;

    public CompoundController(CompoundRepository compoundRepository) {
        this.compoundRepository = compoundRepository;
    }

    @PostMapping("/compound")
    public Compound create(@RequestBody Compound compound) {
        return compoundRepository.save(compound);
    }

    @GetMapping("/compound")
    public List<Compound> findAll() {
        return compoundRepository.findAll();
    }
}
