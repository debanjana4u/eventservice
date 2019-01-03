package com.microworld.ems.eventservice.controller;

import com.microworld.ems.eventservice.handler.EventManager;
import com.microworld.ems.eventservice.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventManager eventManager;

    @RequestMapping("/events")
    public List<Event> getAllEvents(){
        //return "Hello World!";

       List<Event> eventsList =  eventManager.findEventList();
       return eventsList;
    }

}
