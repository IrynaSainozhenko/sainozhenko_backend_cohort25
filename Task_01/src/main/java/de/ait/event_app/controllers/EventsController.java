package de.ait.event_app.controllers;

import de.ait.event_app.models.Event;
import de.ait.event_app.services.EventsService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EventsController {

    private final Scanner scanner;

    private final EventsService eventsService;

    public EventsController(Scanner scanner, EventsService eventsService) {
        this.scanner = scanner;
        this.eventsService = eventsService;
    }

    public void addEvent() {

        System.out.println("Enter the title of event");
        String title = scanner.nextLine();

        System.out.println("Enter the date of events start in format yyyy-mm-dd");
        String stringStartDate = scanner.nextLine();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dateOfStart = LocalDate.parse(stringStartDate, formatter1);


        System.out.println("Enter the date of events end in format yyyy-mm-dd");
        String stringEndDate = scanner.nextLine();

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dateOfEnd = LocalDate.parse(stringEndDate, formatter2);

        Event event = eventsService.addEvent(title, dateOfStart, dateOfEnd);

        System.out.println(event);
    }

    public void getAllEvents() {
        List<Event> events = eventsService.getAllEvents();

        System.out.println(events);

    }
}

