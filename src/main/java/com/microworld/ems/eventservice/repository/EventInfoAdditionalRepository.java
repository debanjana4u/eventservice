package com.microworld.ems.eventservice.repository;

import com.microworld.ems.eventservice.model.EventsTable;

import java.time.OffsetDateTime;
import java.util.List;

public interface EventInfoAdditionalRepository {

    List<EventsTable> findByEmailAddressAndType(String eventHolderEmail, String eventType);

//    List<EventsTable> findEventsByDates(OffsetDateTime startDate, OffsetDateTime endDate, int limit);

}
