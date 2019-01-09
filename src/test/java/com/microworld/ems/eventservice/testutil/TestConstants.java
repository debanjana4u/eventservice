package com.microworld.ems.eventservice.testutil;

import com.microworld.ems.eventservice.model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TestConstants {

    public static Event getAnEvent(){
        Event myEvent = new Event();
        myEvent.setEventId(UUID.randomUUID().toString());
        myEvent.setEventHolderEmail("debanjana4u@gmail.com");
        myEvent.setZipCode(Integer.valueOf(1000));
        myEvent.setStartDate(new Date());
        myEvent.setEndDate(new Date());
        return myEvent;
    }

    public static List<Event> getEventList(){
        List<Event > eventList = new ArrayList<Event>();
        Event myEvent = new Event();
        myEvent.setEventId(UUID.randomUUID().toString());
        myEvent.setEventHolderEmail("debanjana4u@gmail.com");
        myEvent.setZipCode(Integer.valueOf(1000));
        myEvent.setStartDate(new Date());
        myEvent.setEndDate(new Date());
        eventList.add(myEvent);
        return eventList;
    }
}
