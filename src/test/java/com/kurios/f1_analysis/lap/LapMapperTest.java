package com.kurios.f1_analysis.lap;

import com.kurios.f1_analysis.compound.CompoundResponseDto;
import org.junit.jupiter.api.*;

import java.time.Instant;
import java.util.Date;

class LapMapperTest {

    private LapMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new LapMapper();
    }

    @Test
    public void shouldMapLapDtoToLap() {
        var date = Date.from(Instant.parse("2025-05-16T15:43:45Z"));
        LapDto lapDto =  new LapDto(
                1,
                1,
                1,
                60000,
                (short) 2,
                (short) 1,
                (Integer) null,
                (Integer) null,
                20000,
                19000,
                21000,
                10000000,
                10020000,
                10039000,
                (short) 200,
                (short) 250,
                (short) 300,
                (short) 350,
                false,
                (short) 3,
                10000000,
                date,
                (Short) null,
                false,
                true
                );
    }

}