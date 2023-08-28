package de.ait.event_app.repositories.impl;

import de.ait.event_app.models.Event;
import de.ait.event_app.repositories.EventsRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EventsRepositoryFileImpl implements EventsRepository {

    private final String fileName;

    private Long generatedId = 1L;

    public EventsRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return null;
    }

    @Override
    public void save(Event event) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            event.setId(generatedId);

            writer.write(event.getId() + "|" + event.getTitle() +"|" + event.getDateOfStart() + "|" + event.getDateOfEnd());
            writer.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Problems with file: " + e.getMessage());
        }

        generatedId++;

    }

    @Override
    public void update(Event model) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
