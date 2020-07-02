package com.bd.projManagement.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventDto {
    private String id;
    private String eventLabel;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String eventDesc;



}
