package com.kurios.f1_analysis.event_round;

import org.springframework.stereotype.Service;


@Service
public class EventRoundMapper {

    public EventRound toEventRound(EventRoundDto eventRoundDto) {
        if (eventRoundDto == null) {
            throw new NullPointerException("eventRoundDto should not be null");
        }
        var eventRound = new EventRound();
        eventRound.setYear(eventRoundDto.year());
        eventRound.setRoundNumber(eventRoundDto.roundNumber());
        eventRound.setCountry(eventRoundDto.country());
        eventRound.setLocation(eventRoundDto.location());
        eventRound.setEventName(eventRoundDto.eventName());
        eventRound.setEventDate(eventRoundDto.eventDate());
        eventRound.setSprintEvent(eventRoundDto.isSprintEvent());
        eventRound.setSoft(eventRoundDto.soft());
        eventRound.setMedium(eventRoundDto.medium());
        eventRound.setHard(eventRoundDto.hard());

        return eventRound;
    }

    public EventRoundDto toEventRoundDto(EventRound eventRound)   {
        return new EventRoundDto(
                eventRound.getYear(),
                eventRound.getRoundNumber(),
                eventRound.getCountry(),
                eventRound.getLocation(),
                eventRound.getEventName(),
                eventRound.getEventDate(),
                eventRound.getSprintEvent(),
                eventRound.getSoft(),
                eventRound.getMedium(),
                eventRound.getHard()
        );
    }
    public EventRoundResponseDto toEventRoundResponseDto(EventRound eventRound)   {
        return new EventRoundResponseDto(
                eventRound.getYear(),
                eventRound.getRoundNumber(),
                eventRound.getEventDate(),
                eventRound.getSprintEvent()
        );
    }
}
