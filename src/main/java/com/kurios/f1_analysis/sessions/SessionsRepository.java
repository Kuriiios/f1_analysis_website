package com.kurios.f1_analysis.sessions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionsRepository extends JpaRepository<Sessions, Integer> {

    List<Sessions> findAll();

    Sessions findAllById(Integer id);
}
