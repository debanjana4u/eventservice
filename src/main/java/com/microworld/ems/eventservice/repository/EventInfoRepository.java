package com.microworld.ems.eventservice.repository;

import com.microworld.ems.eventservice.model.EventsTable;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface EventInfoRepository extends CrudRepository<EventsTable,String> {

    public EventsTable save(EventsTable event);

    public List<EventsTable> findAll();

}
