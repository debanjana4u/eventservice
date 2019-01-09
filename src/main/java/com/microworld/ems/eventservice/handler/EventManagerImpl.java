package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class EventManagerImpl implements EventManager {
    @Override
    public void bookEvent() {

    }

    @Override
    public Event findEventById(String id) {
        List <Event> eventList = new ArrayList<Event>();

        Event myEvent = new Event();
        myEvent.setEventId(UUID.randomUUID().toString());
        myEvent.setEventHolderEmail("debanjana4u@gmail.com");
        myEvent.setZipCode(Integer.valueOf(1000));
        myEvent.setStartDate(new Date());
        myEvent.setEndDate(new Date());

        Event yourEvent = new Event();
        yourEvent.setEventId(UUID.randomUUID().toString());
        yourEvent.setEventHolderEmail("debanjana4u@gmail.com");
        yourEvent.setZipCode(Integer.valueOf(1000));
        yourEvent.setStartDate(new Date());
        yourEvent.setEndDate(new Date());
        eventList.add(myEvent);
        eventList.add(yourEvent);
        for(Event event : eventList) {
            if (event != null && event.getEventId().equalsIgnoreCase(id)) {
                return event;
            }
        }
    return null;
    }

    @Override
    public void findEventByZipCodes() {

    }

    @Override
    public void findAvailabilityByDates() {

    }

    @Override
    public List<Event> findEventList(OffsetDateTime startDate, OffsetDateTime endDate, int limit){
        List <Event> eventList = new ArrayList<Event>();

//        Event myEvent = new Event();
//        myEvent.setEventId(Integer.valueOf(100));
//        myEvent.setEventHolderEmail("debanjana4u@gmail.com");
//        myEvent.setZipCode(Integer.valueOf(1000));
//        myEvent.setStartDate(new Date());
//        myEvent.setEndDate(new Date());
//        eventList.add(myEvent);


    return eventList;
    }
}
