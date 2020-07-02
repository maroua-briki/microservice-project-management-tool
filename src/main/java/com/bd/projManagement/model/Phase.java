package com.bd.projManagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "Phase")
public class Phase {
    @Id
    private String id;
    private String phaseLabel;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;
    @DBRef
    private Project project;

}
