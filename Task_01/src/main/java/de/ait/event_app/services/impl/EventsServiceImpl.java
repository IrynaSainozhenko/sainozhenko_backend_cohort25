package de.ait.event_app.services.impl;

import de.ait.event_app.models.Event;
import de.ait.event_app.repositories.EventsRepository;
import de.ait.event_app.services.EventsService;

import java.time.LocalDate;

public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    public EventsServiceImpl(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public Event addEvent(String title, LocalDate dateOfStart, LocalDate dateOfEnd) {
        if (title == null || title.equals(" ") || title.equals("")) {
            throw new IllegalArgumentException("Поле title не может быть пустым");
        }
        // add for localdate

        Event event = new Event(title, dateOfStart, dateOfEnd);

        eventsRepository.save(event);

        return event;
    }
}
