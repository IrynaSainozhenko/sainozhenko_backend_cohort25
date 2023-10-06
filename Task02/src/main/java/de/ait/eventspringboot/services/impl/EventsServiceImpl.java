package de.ait.eventspringboot.services.impl;

import de.ait.eventspringboot.models.Event;
import de.ait.eventspringboot.repositories.EventsRepository;
import de.ait.eventspringboot.services.EventsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    private final EventsRepository eventsRepository;

    public EventsServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public void addEvent(String title, String description) {

        Event event = new Event(title, description);

        eventsRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }
}
