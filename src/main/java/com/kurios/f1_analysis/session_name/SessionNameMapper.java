package com.kurios.f1_analysis.session_name;

import org.springframework.stereotype.Service;

@Service
public class SessionNameMapper {

    public SessionNameResponseDto toSessionNameResponseDto(SessionName sessionName) {
        return new SessionNameResponseDto(
                sessionName.getId(),
                sessionName.getSessionName()
        );
    }
}
