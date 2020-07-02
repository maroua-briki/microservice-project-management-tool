package com.bd.projManagement.controller;

import com.bd.projManagement.service.dto.EventDto;
import com.bd.projManagement.service.serviceImpl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin("*")
public class EventController {
    @Autowired
    EventServiceImpl eventService;

    @PostMapping("/create")
    EventDto create(@RequestBody EventDto eventDto) {
        return eventService.createEvent(eventDto);
    }

    @GetMapping("/{id}")
    EventDto getOne(@PathVariable("id") String id) {
        return eventService.findEventById(id);
    }

    @PutMapping("/update/{id}")
    EventDto update(@PathVariable("id") String id, @RequestBody EventDto eventDto) {
        return eventService.updateEvent(id, eventDto);
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable String id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping
    List<EventDto> getAll() {
        return eventService.getAllEvents();
    }

}
