package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EventManagerImpl implements EventManager {
    @Override
    public void bookEvent() {

    }

    @Override
    public void findEventById() {

    }

    @Override
    public void findEventByZipCodes() {

    }

    @Override
    public void findAvailabilityByDates() {

    }

    @Override
    public List<Event> findEventList(){
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
