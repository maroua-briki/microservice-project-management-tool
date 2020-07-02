package com.bd.projManagement.service;

import com.bd.projManagement.service.dto.TaskDto;

import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto findTaskById(String id);

    TaskDto updateTask(String id, TaskDto taskDto);

    String deleteTask(String id);

    List<TaskDto> getAll();
}
