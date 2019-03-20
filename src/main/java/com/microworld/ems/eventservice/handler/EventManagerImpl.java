package com.microworld.ems.eventservice.handler;

import com.microworld.ems.eventservice.model.Event;
import com.microworld.ems.eventservice.model.EventsTable;
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
    public  List<Event> findEventsByEmailAndType(String eventHolderEmail, String eventType){
        List<EventsTable> eventsTableList =  eventInfoRepository.findByEmailAddressAndType(eventHolderEmail, eventType);
        List<Event> eventList = new ArrayList<Event>();
        for (EventsTable eventsTable: eventsTableList){
            eventList.add(Event.getEvent(eventsTable));
        }
        //Convert EventsTable to events
        return eventList;
    }

    @Override
    public void findEventByZipCodes() {

    }

    @Override
    public void findAvailabilityByDates() {

    }

//    @Override
//    public List<Event> findEventListByDates(OffsetDateTime startDate, OffsetDateTime endDate, int limit){
//        List<EventsTable> eventsTableList =  eventInfoRepository.findEventsByDates(startDate, endDate, limit);
//        List<Event> eventList = new ArrayList<Event>();
//        for (EventsTable eventsTable: eventsTableList){
//            eventList.add(Event.getEvent(eventsTable));
//        }
//         //Convert EventsTable to events
//    return eventList;
//    }
}
