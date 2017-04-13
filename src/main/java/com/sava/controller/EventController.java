package com.sava.controller;

import com.sava.model.Event;
import com.sava.repository.interfaces.EventRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@Api(
        name = "Event API",
        description = "Provides a list of methods that manage Events"
)
public class EventController {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping(value = "/events")
    @ApiMethod(description = "Create one Event and save it to the database. Date pattern: {dd-MM-yyyy HH:mm}")
    public Event create(@RequestBody Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    @ApiMethod(description = "Get one Event from the database by id")
    public Event get(@ApiPathParam(name = "id") @PathVariable Long id) {
        return eventRepository.findOne(id);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ApiMethod(description = "Get all Events from the database")
    public List<Event> list() {
        return eventRepository.findAll();
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.PUT)
    @ApiMethod(description = "Edit Event's fields by id and save it to the database")
    public Event update(@ApiPathParam(name = "id") @PathVariable Long id,
                        @RequestBody Event event) {
        Event loadedEvent = eventRepository.findOne(id);
        BeanUtils.copyProperties(event, loadedEvent);
        return eventRepository.saveAndFlush(loadedEvent);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Delete one Event from the database by id")
    public void delete(@ApiPathParam(name = "id") @PathVariable Long id) {
        Event loadedEvent = eventRepository.findOne(id);
        eventRepository.delete(loadedEvent);
    }

}
