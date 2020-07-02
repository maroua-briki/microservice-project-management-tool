package com.bd.projManagement.service.dto;

import lombok.Data;

@Data
public class TicketDto {
    private String id;
    private String ticketLabel;
    private String ticketDesc;
    //enumeration
    private String status;

}
