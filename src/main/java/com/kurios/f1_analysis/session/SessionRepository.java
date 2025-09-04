package com.kurios.f1_analysis.session;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findAll();

    Session findAllById(Integer id);
}
