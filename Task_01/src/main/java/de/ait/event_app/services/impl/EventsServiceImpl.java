package de.ait.event_app.services.impl;

import de.ait.event_app.models.Event;
import de.ait.event_app.repositories.EventsRepository;
import de.ait.event_app.services.EventsService;

import java.time.LocalDate;
import java.util.List;

public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    public EventsServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public Event addEvent(String title, LocalDate dateOfStart, LocalDate dateOfEnd) {
        if (title == null || title.equals(" ") || title.equals("")) {
            throw new IllegalArgumentException("The title field cannot be empty");
        }
        if (dateOfStart.isAfter(dateOfEnd)) {
            throw new IllegalArgumentException("The end date cannot be earlier than the start date");
        }

        Event existedUEvent = eventsRepository.findOneByTitle(title);

        if (existedUEvent != null) {
            throw new IllegalArgumentException("Event with that title is already exists");
        }

        Event event = new Event(title, dateOfStart, dateOfEnd);

        eventsRepository.save(event);

        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }
}
