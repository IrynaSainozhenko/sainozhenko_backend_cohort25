package de.ait.eventspringboot.repositories;

import de.ait.eventspringboot.models.Event;

public interface EventsRepository extends CrudRepository<Event>{

    Event findEventByTitle(String title);


}
