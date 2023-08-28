package de.ait.event_app.repositories.impl;

import de.ait.event_app.models.Event;
import de.ait.event_app.repositories.EventsRepository;

import java.util.ArrayList;
import java.util.List;

public class EventsRepositoryListImpl implements EventsRepository {

    private final List<Event> events = new ArrayList<>();
    private Long generatedId = 1L;

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public void save(Event event) {
        events.add(event);

        event.setId(generatedId);

        generatedId++;
    }

    @Override
    public void update(Event model) {
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public Event findOneByTitle(String title) {
        return events.stream()
                .filter(user -> user.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }
}
