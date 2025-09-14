package com.kurios.f1_analysis.session_name;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionNameService {

    private final SessionNameRepository sessionNameRepository;

    private final SessionNameMapper sessionNameMapper;


    public SessionNameService(SessionNameRepository sessionNameRepository, SessionNameMapper sessionNameMapper) {
        this.sessionNameRepository = sessionNameRepository;
        this.sessionNameMapper = sessionNameMapper;
    }

    public List<SessionNameResponseDto> findAll() {
        return sessionNameRepository.findAll()
                .stream()
                .map(sessionNameMapper::toSessionNameResponseDto)
                .collect(Collectors.toList());
    }

    public SessionNameResponseDto findById(Integer id) {
        return sessionNameRepository.findById(id)
                .map(sessionNameMapper::toSessionNameResponseDto)
                .orElse(null);
    }
}

