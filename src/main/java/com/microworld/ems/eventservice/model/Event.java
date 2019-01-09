package com.microworld.ems.eventservice.model;

import lombok.Data;
import lombok.Value;

import java.util.Date;
import java.util.Objects;

//@Value
@Data
public class Event {

    private String eventId;
    private Date startDate;
    private Date endDate;
    private String eventHolderEmail;
    private long zipCode;
    private static enum eventType{
        ANNIVERSARY, BIRTHDAY, BUSINESS;
    }

}
