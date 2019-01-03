package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;

import java.util.List;


public interface EventManager {

    public void bookEvent();

    public void findEventById();

    public void findEventByZipCodes();

    public void findAvailabilityByDates();

    public List<Event> findEventList();

}
