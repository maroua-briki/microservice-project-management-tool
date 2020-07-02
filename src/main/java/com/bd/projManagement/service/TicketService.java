package com.bd.projManagement.service;

import com.bd.projManagement.service.dto.TicketDto;

import java.util.List;

public interface TicketService {

    TicketDto createTicket(TicketDto ticketDto);

    TicketDto findTicketById(String id);

    TicketDto updateTicket(String id, TicketDto ticketDto);

    String deleteTicket(String id);

     List<TicketDto> getTickets();
}
