package com.bd.projManagement.service;

import com.bd.projManagement.service.dto.EventDto;

import java.util.List;

public interface EventService {

    EventDto createEvent(EventDto eventDto);

     EventDto findEventById(String id);

 EventDto updateEvent(String id, EventDto eventDto);

     String deleteEvent(String id);

    List<EventDto> getAllEvents();
}
