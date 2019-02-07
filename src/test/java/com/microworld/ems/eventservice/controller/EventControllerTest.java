package com.microworld.ems.eventservice.controller;

import com.microworld.ems.eventservice.exception.ValidationException;
import com.microworld.ems.eventservice.handler.EventManager;
import com.microworld.ems.eventservice.model.Event;
import com.microworld.ems.eventservice.testutil.TestConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {


    private EventController eventController;
    private MockMvc mockMvc;

    private EventManager eventManager = mock(EventManager.class);

    @Before
    public void setUp() throws Exception {
        eventController = new EventController();
        eventController.setEventManager(eventManager);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindById_Ok_Response() throws Exception {

        when(eventManager.findEventById(Mockito.anyString())).thenReturn(TestConstants.getAnEvent());
        Event returnedEvent = eventController.findById(Mockito.anyString());

        verify(eventManager, times(1)).findEventById(Mockito.anyString());
        assertNotNull(returnedEvent);
    }

    @Test
    public void testGetEventsByDate_Ok_Response() throws Exception {
        OffsetDateTime startDate = OffsetDateTime.parse("2018-10-26T12:00-06:00");
        OffsetDateTime endDate = OffsetDateTime.now();
        when(eventManager.findEventList(startDate,endDate,10)).thenReturn(TestConstants.getEventList());
        List<Event> returnedEventList = eventController.getEventsByDate(startDate.toString(),endDate.toString(),10);
        verify(eventManager, times(1)).findEventList(startDate,endDate,10);
        assertNotNull(returnedEventList);
    }

   @Test(expected = ValidationException.class)
    public void testGetEventsByDate_LimitValidation_400_Response() throws Exception {
        OffsetDateTime startDate = OffsetDateTime.parse("2018-10-26T12:00-06:00");
        OffsetDateTime endDate = OffsetDateTime.now();
        List<Event> returnedEventList = eventController.getEventsByDate("2018-10-26T12:00-06:00",endDate.toString(),-1);
        verify(eventManager, times(1)).findEventList(startDate,endDate,-1);
        assertNotNull(returnedEventList);
    }

   @Test(expected = ValidationException.class)
    public void testGetEventsByDate_DateValidation_400_Response() throws Exception {
        OffsetDateTime startDate = OffsetDateTime.now();
        OffsetDateTime endDate = OffsetDateTime.parse("2018-10-26T12:00-06:00");
        List<Event> returnedEventList = eventController.getEventsByDate(startDate.toString(), endDate.toString(),100);
        verify(eventManager, times(1)).findEventList(startDate,endDate,100);
        assertNotNull(returnedEventList);
    }

    @Test
    public void testCreateEvent_Ok_Response() throws Exception {
        when(eventManager.bookEvent(Mockito.any())).thenReturn(Mockito.anyString());
        ResponseEntity<?> responseEntity = eventController.createEvent(TestConstants.getAnEvent());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.ACCEPTED);
       // verify(eventManager, times(1)).bookEvent(TestConstants.getAnEvent());
    }

}