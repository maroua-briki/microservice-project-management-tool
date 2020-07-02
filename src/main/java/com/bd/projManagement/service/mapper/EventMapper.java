package com.bd.projManagement.service.mapper;

import com.bd.projManagement.model.Event;
import com.bd.projManagement.service.dto.EventDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    /*==================== to Dto ======================*/
    EventDto toDto(Event event);

    List<EventDto> toEventDtoList(List<Event> eventList);

    /*===================== to Project ============================*/
    Event toEvent(EventDto eventDto);

    List<Event> toEventList(List<EventDto> eventDtoList);
}
