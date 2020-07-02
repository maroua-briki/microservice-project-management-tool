package com.bd.projManagement.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PhaseDto {
    private String id;
    private String phaseLabel;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TaskDto> tasks;
    private ProjectDto project;


}
