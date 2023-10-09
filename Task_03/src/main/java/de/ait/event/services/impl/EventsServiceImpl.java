package de.ait.event.services.impl;


import de.ait.event.dto.EventDto;
import de.ait.event.dto.NewEventDto;
import de.ait.event.models.Event;
import de.ait.event.repositories.EventsRepository;
import de.ait.event.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static de.ait.event.dto.EventDto.from;
@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    @Override
    public List<EventDto> getAllEvents() {

        return from(eventsRepository.findAll());
    }

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = new Event(newEvent.getTitle(),
                newEvent.getDescription());

        eventsRepository.save(event);

        return from(event);
    }
}
