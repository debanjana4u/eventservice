package com.microworld.ems.eventservice.controller;

import com.microworld.ems.eventservice.exception.ValidationException;
import com.microworld.ems.eventservice.handler.EventManager;
import com.microworld.ems.eventservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventManager eventManager;

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEventsByDate(@RequestParam(value = "startDate", required = true) String startDate,
                                    @RequestParam(value = "endDate", required = true) String endDate,
                                    @RequestParam(value = "limit", required = false, defaultValue = "10") int limit){
        //return "Hello World!";
        OffsetDateTime startDt = OffsetDateTime.parse(startDate);
        OffsetDateTime endDt = OffsetDateTime.parse(endDate);
        if (limit<=0){
            throw new ValidationException("Limit should be greater than 0.");
        }
        if (endDt.isBefore(startDt)){
            throw new ValidationException("Event End Date should be greater than Start date");
        }


       List<Event> eventsList =  eventManager.findEventList(startDt,endDt,limit);
       return eventsList;
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Event findById(@PathVariable("id") String id) {
        Event event =  eventManager.findEventById(id);
        return event;
    }

}
