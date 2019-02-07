package com.microworld.ems.eventservice.model;

import lombok.Data;

import java.util.Date;

//@Value
@Data
public class Event {

    private String eventId;
    private Date startDate;
    private Date endDate;
    private String eventHolderEmail;
    private long zipCode;
    public enum EventType{
        ANNIVERSARY, BIRTHDAY, BUSINESS;
    }

    public EventsTable getEventRespositoryModel(){
        return EventsTable.builder().eventHolderEmail(this.eventHolderEmail)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .zipCode(this.zipCode)
                .eventType(EventType.values()[0].toString()).build();
    }


}
