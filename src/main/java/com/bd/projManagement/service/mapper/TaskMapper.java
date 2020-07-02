package com.bd.projManagement.service.mapper;

import com.bd.projManagement.model.Task;
import com.bd.projManagement.service.dto.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TicketMapper.class)
public interface TaskMapper {
    TaskDto toTaskDto(Task task);

    Task toTask(TaskDto taskDto);

    List<TaskDto> toTaskDtoList(List<Task> taskList);

    List<Task> toTaskList(List<TaskDto> taskDtoList);


}
