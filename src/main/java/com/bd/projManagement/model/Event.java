package com.bd.projManagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Document(collection = "Event")
public class Event {
    @Id
    private String id;
    private String eventLabel;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private String eventDesc;

}
