package de.ait.event_app.repositories;

import de.ait.event_app.models.Event;

public interface EventsRepository extends CrudRepository<Event>{

    Event findOneByTitle(String title);
}
