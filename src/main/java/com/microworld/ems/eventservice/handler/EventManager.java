package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;

import java.time.OffsetDateTime;
import java.util.List;


public interface EventManager {

    public String bookEvent(Event event);

    public Event findEventById(String id);

    public void findEventByZipCodes();

    public void findAvailabilityByDates();

//    public List<Event> findEventListByDates(OffsetDateTime startDate, OffsetDateTime endDate, int limit);

    public  List<Event> findEventsByEmailAndType(String eventHolderEmail, String eventType);

}
