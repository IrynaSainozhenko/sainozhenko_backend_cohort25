package de.ait.eventspringboot.services;


import de.ait.eventspringboot.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventsService {
    void addEvent(String title, String description);

    List<Event> getAllEvents();
}
