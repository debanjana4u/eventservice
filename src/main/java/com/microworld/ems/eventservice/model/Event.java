package com.microworld.ems.eventservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

//@Value
@Data
@Builder
public class Event {

    private String eventId;
    private Date startDate;
    private Date endDate;
    private String eventHolderEmail;
    private long zipCode;
    private String eventType;


    public static  EventsTable getEventRespositoryModel( Event event){
        EventsTable eventsTable = new EventsTable();
        eventsTable.setEndDate(event.endDate);
        eventsTable.setStartDate(event.startDate);
        eventsTable.setEventHolderEmail(event.eventHolderEmail);
        eventsTable.setZipCode(event.zipCode);
        eventsTable.setEventType(event.eventType);

        return eventsTable;
    }


    public static Event getEvent(EventsTable eventsTable){
        System.out.println("############ " + eventsTable );
        return Event.builder()
                .eventType(eventsTable.getEventType())
                .eventId(eventsTable.getEventId())
                .endDate(eventsTable.getEndDate())
                .startDate(eventsTable.getStartDate())
                .eventHolderEmail(eventsTable.getEventHolderEmail())
                .zipCode(eventsTable.getZipCode()).build();
    }





}
