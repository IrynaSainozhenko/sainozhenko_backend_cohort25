package de.ait.event.controllers;

import de.ait.event.dto.EventDto;
import de.ait.event.dto.NewEventDto;
import de.ait.event.models.Event;
import de.ait.event.services.EventsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Tags(value = @Tag(name = "Events"))
@RequiredArgsConstructor
@Controller

public class EventsController {

    private final EventsService eventsService;

    @Operation(summary = "Getting all events")
    @GetMapping("/events")
    @ResponseBody
    public List<EventDto> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @Operation(summary = "Adding a new event")
    @PostMapping("/events")
    @ResponseBody
    public EventDto addEvent(@RequestBody NewEventDto newEvent) {
        return eventsService.addEvent(newEvent);
    }
}

