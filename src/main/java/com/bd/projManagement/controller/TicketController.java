package com.bd.projManagement.controller;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.service.dto.TicketDto;
import com.bd.projManagement.service.serviceImpl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin("*")

public class TicketController {

    @Autowired
    private TicketServiceImpl ticketServiceImpl;

    @PostMapping("/create")
    TicketDto create(@RequestBody TicketDto ticketDto) {
        System.out.println("the ticket u wanna create is: " + ticketDto);
        return ticketServiceImpl.createTicket(ticketDto);
    }

    @GetMapping("/{id}")
    TicketDto getOne(@PathVariable("id") String id) throws DocumentNotFoundException {
        return ticketServiceImpl.findTicketById(id);
    }

    @PutMapping("/update/{id}")
    TicketDto update(@PathVariable("id") String id, @RequestBody TicketDto ticketDto) throws DocumentNotFoundException {
        return ticketServiceImpl.updateTicket(id, ticketDto);
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable String id) throws DocumentNotFoundException {
        return ticketServiceImpl.deleteTicket(id);
    }

    @GetMapping
    List<TicketDto> getAll() {
        return ticketServiceImpl.getTickets();
    }
}
