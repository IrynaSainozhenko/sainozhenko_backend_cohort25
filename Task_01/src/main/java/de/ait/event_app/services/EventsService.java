package de.ait.event_app.services;

import de.ait.event_app.models.Event;

import java.time.LocalDate;

public interface EventsService {
    Event addEvent(String title, LocalDate dateOfStart, LocalDate dateOfEnd);
}
