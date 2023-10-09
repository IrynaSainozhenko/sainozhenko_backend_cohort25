package de.ait.event.repositories.impl;

import de.ait.event.models.Event;
import de.ait.event.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventsRepositoryFileImpl implements EventsRepository {

    private final String fileName;

    public EventsRepositoryFileImpl(@Value("${events.file-name}") String fileName) {
        this.fileName = fileName;
    }


    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return reader.lines()
                    .map(line -> line.split("#"))
                    .map(parsed -> new Event(parsed[0], parsed[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Problems with reading from file: " + e.getMessage());
        }
    }

    @Override
    public void save(Event event) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            writer.write(event.getTitle() + "#" + event.getDescription());
            writer.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException("Problems with file: " + e.getMessage());
        }
    }

    @Override
    public void update(Event model) {
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public Event findEventByTitle(String title) {
        return null;
    }

}
