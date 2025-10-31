package com.kurios.f1_analysis.team_radio;

import java.util.Date;

public record TeamRadioResponseDto(
    Date dateTime,
    String teamRadioMessage,
    String teamRadioUrl
) {
}
