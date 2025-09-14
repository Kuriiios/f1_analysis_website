package com.kurios.f1_analysis.session_name;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionNameRepository extends JpaRepository<SessionName, Integer> {
    SessionName getSessionNameById(Integer id);
}
