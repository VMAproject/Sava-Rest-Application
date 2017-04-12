package com.sava.controller;

import com.sava.model.Event;
import com.sava.repository.interfaces.EventRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EventController {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public Event create(@RequestBody Event event) {
        return eventRepository.saveAndFlush(event);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public Event get(@PathVariable Long id) {
        return eventRepository.findOne(id);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> list() {
        return eventRepository.findAll();
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.PUT)
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        Event loadedEvent = eventRepository.findOne(id);
        BeanUtils.copyProperties(event, loadedEvent);
        return eventRepository.saveAndFlush(loadedEvent);
    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Event loadedEvent = eventRepository.findOne(id);
        eventRepository.delete(loadedEvent);
    }

}
