package de.ait.event_app.models;

import java.time.LocalDate;
import java.util.Objects;

public class Event {

    private Long id;
    private String title;
    private LocalDate dateOfStart;
    private LocalDate dateOfEnd;

    public Event(Long id, String title, LocalDate dateOfStart, LocalDate dateOfEnd) {
        this.id = id;
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
    }

    public Event() {
    }

    public Event(String title, LocalDate dateOfStart, LocalDate dateOfEnd) {
        this.title = title;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(title, event.title) && Objects.equals(dateOfStart, event.dateOfStart) && Objects.equals(dateOfEnd, event.dateOfEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dateOfStart, dateOfEnd);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfEnd=" + dateOfEnd +
                '}';
    }
}
