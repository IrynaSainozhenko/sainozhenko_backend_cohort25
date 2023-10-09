package de.ait.event.services;

import de.ait.event.dto.EventDto;
import de.ait.event.dto.NewEventDto;
import de.ait.event.models.Event;

import java.util.List;

public interface EventsService {

    List<EventDto> getAllEvents();

    EventDto addEvent(NewEventDto newEvent);
}
