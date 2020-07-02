package com.bd.projManagement.service.serviceImpl;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.model.Ticket;
import com.bd.projManagement.repository.TicketRepository;
import com.bd.projManagement.service.TicketService;
import com.bd.projManagement.service.dto.TicketDto;
import com.bd.projManagement.service.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;

    /*============================ create a new ticket ========================================*/
    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.toTicket(ticketDto);
        Ticket createdTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(createdTicket);
    }

    /*============================ get a ticket with its id ========================================*/
    @Override
    public TicketDto findTicketById(String id) throws DocumentNotFoundException {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            Ticket found = ticket.get();
            return ticketMapper.toDto(found);
        } else throw new DocumentNotFoundException("No ticket provided for the given id");
    }

    /*============================ update a ticket with its id ========================================*/
    @Override
    public TicketDto updateTicket(String id, TicketDto ticketDto) throws DocumentNotFoundException {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            Ticket updated = ticket.get();
            updated.setTicketLabel(ticketDto.getTicketLabel());
            updated.setTicketDesc(ticketDto.getTicketDesc());
            updated.setStatus(ticketMapper.toTicket(ticketDto).getStatus());
            updated = ticketRepository.save(updated);
            return ticketMapper.toDto(updated);
        } else throw new DocumentNotFoundException("No ticket provided for the given id");
    }

    /*============================ delete a ticket with its id ========================================*/
    @Override
    public String deleteTicket(String id) throws DocumentNotFoundException {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (ticket.isPresent()) {
            ticketRepository.deleteById(id);
            return "deleted successfully";
        } else throw new DocumentNotFoundException("No ticket found for the given id");
    }

    /*============================ get all tickets ========================================*/
    @Override
    public List<TicketDto> getTickets() {
        List<Ticket> ticketList = ticketRepository.findAll();
        List<TicketDto> ticketDtoList = ticketMapper.toDtoList(ticketList);
        if (ticketDtoList.size() > 0) return ticketDtoList;
        return new ArrayList<>();
    }
}
