package de.ait.event.dto;

import de.ait.event.models.Event;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Event", description = "Information about event")
public class EventDto {

    private String title;

    private String description;

    public static EventDto from(Event event) {

        return new EventDto(event.getTitle(), event.getDescription());
    }

    public static List<EventDto> from(List<Event> events) {
        List<EventDto> eventDtos = new ArrayList<>();

        for (Event event : events) {
            EventDto eventDto = from(event);

            eventDtos.add(eventDto);
        }

        return eventDtos;
    }
}
