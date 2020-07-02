package com.bd.projManagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Ticket")
public class Ticket {
    @Id
    private String id;
    private String ticketLabel;
    private String ticketDesc;
    private Status status;  //enumeration
}
