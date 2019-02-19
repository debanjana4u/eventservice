package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;
import com.microworld.ems.eventservice.repository.EventInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventManagerImpl implements EventManager {

    @Autowired
    private EventInfoRepository eventInfoRepository;

    @Override
    public String bookEvent(Event event) {
        return eventInfoRepository.save(Event.getEventRespositoryModel(event)).getEventId();
    }

    @Override
    public Event findEventById(String id) {
       Event event =  Event.getEvent(eventInfoRepository.findById(id).get());
        System.out.println("Retrieving event=" + event +" for eventId=" + id);
       return event;
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
