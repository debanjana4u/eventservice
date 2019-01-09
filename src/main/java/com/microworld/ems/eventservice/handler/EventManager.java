package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;

import java.time.OffsetDateTime;
import java.util.List;


public interface EventManager {

    public void bookEvent();

    public Event findEventById(String id);

    public void findEventByZipCodes();

    public void findAvailabilityByDates();

    public List<Event> findEventList(OffsetDateTime startDate, OffsetDateTime endDate, int limit);

}
