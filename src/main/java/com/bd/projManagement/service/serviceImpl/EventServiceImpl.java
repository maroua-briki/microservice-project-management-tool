package com.bd.projManagement.service.serviceImpl;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.model.Event;
import com.bd.projManagement.repository.EventRepository;
import com.bd.projManagement.service.EventService;
import com.bd.projManagement.service.dto.EventDto;
import com.bd.projManagement.service.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventMapper eventMapper;
    @Autowired
    EventRepository eventRepository;


    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.toEvent(eventDto);
        Event created = eventRepository.save(event);
        System.out.println("event created in event service"+created);

        return eventMapper.toDto(created);


    }

    @Override
    public EventDto findEventById(String id) throws DocumentNotFoundException {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event found = event.get();
            return eventMapper.toDto(found);
        } else throw new DocumentNotFoundException("No event found with the given id");


    }

    @Override
    public EventDto updateEvent(String id, EventDto eventDto) throws DocumentNotFoundException {
        System.out.println("bnjr " + eventDto);
        Optional<Event> event = eventRepository.findById(id);
        System.out.println(event);
        if (event.isPresent()) {
            Event updated = event.get();
            System.out.println(event);
            updated.setEventLabel(eventDto.getEventLabel());
            updated.setEventDate(eventDto.getEventDate());
            updated.setEventDesc(eventDto.getEventDesc());
            System.out.println(updated);
            updated = eventRepository.save(updated);
            System.out.println(updated);
            return eventMapper.toDto(updated);
        } else throw new DocumentNotFoundException("No event found with the given id");
    }

    @Override
    public String deleteEvent(String id) throws DocumentNotFoundException {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.deleteById(id);
            return "deleted successfully";
        } else throw new DocumentNotFoundException("No event found with the given id");
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<EventDto> eventDtoList = eventMapper.toEventDtoList(eventRepository.findAll());
        if (eventDtoList.size() > 0) return eventDtoList;
        return new ArrayList<>();
    }
}
