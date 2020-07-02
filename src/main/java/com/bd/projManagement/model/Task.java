package com.bd.projManagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "Task")
public class Task {
    @Id
    private String id;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
    private String priority;
    private Status status;
    private List<Ticket> tickets;
}
