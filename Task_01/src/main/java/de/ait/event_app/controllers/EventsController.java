package de.ait.event_app.controllers;

import de.ait.event_app.models.Event;
import de.ait.event_app.services.impl.EventsServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class EventsController {

    private final Scanner scanner;

    private final EventsServiceImpl eventsService;

    public EventsController(Scanner scanner, EventsServiceImpl eventsService) {

        this.scanner = scanner;
        this.eventsService = eventsService;
    }

    public void addEvent() {
        System.out.println("Enter the title of event");
        String title = scanner.nextLine();

        System.out.println("Enter the date of events start in format yyyy-mm-dd");
        String stringStartDate = scanner.nextLine();
        LocalDate dateOfStart = LocalDate.parse(stringStartDate);

        System.out.println("Enter the date of events start in format yyyy-mm-dd");
        String stringEndDate = scanner.nextLine();
        LocalDate dateOfEnd = LocalDate.parse(stringEndDate);

        Event event = eventsService.create(title, dateOfStart, dateOfEnd);

        System.out.println(event);
    }
}
