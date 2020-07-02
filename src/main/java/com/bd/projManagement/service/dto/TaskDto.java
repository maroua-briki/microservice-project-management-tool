package com.bd.projManagement.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskDto {
    private String id;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
    private String priority;
    private String status;
    private List<TicketDto> tickets;

}
