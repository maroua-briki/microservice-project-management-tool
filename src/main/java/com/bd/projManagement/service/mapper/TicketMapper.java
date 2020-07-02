package com.bd.projManagement.service.mapper;

import com.bd.projManagement.model.Ticket;
import com.bd.projManagement.service.dto.TicketDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    /*==================== to Dto ======================*/
    TicketDto toDto(Ticket ticket);

    List<TicketDto> toDtoList(List<Ticket> ticketList);

    /*===================== to Project ============================*/
    Ticket toTicket(TicketDto ticketDto);

    List<Ticket> toTicketList(List<TicketDto> ticketDtoList);
}
