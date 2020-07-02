package com.bd.projManagement.service.serviceImpl;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.model.Task;
import com.bd.projManagement.repository.TaskRepository;
import com.bd.projManagement.service.TaskService;
import com.bd.projManagement.service.dto.TaskDto;
import com.bd.projManagement.service.dto.TicketDto;
import com.bd.projManagement.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TicketServiceImpl ticketServiceImpl;

    /*============================ create a new task and its ticket concerns ========================================*/
    @Override
    public TaskDto createTask(TaskDto taskDto) {
        List<TicketDto> ticketList = taskDto.getTickets();
        if (ticketList != null) {
            for (TicketDto ticketDto : ticketList) {
                TicketDto created = ticketServiceImpl.createTicket(ticketDto);
                System.out.println(created);
            }
            Task task = taskMapper.toTask(taskDto);
            Task createdTask = taskRepository.save(task);
            return taskMapper.toTaskDto(createdTask);
        } else {
            Task task = taskMapper.toTask(taskDto);
            Task createdTask = taskRepository.save(task);
            return taskMapper.toTaskDto(createdTask);
        }
    }

    /*============================ find a task by id ========================================*/
    @Override
    public TaskDto findTaskById(String id) throws DocumentNotFoundException {
        Optional<Task> xyz = taskRepository.findById(id);
        if (xyz.isPresent()) {
            Task found = xyz.get();
            return taskMapper.toTaskDto(found);
        } else throw new DocumentNotFoundException("No task provided for the given id");
    }

    /*============================ update a task and also the tickets which are related to, it depends on ur need ========================================*/
    @Override
    public TaskDto updateTask(String id, TaskDto taskDto) throws DocumentNotFoundException {
        Optional<Task> xyz = taskRepository.findById(id);
        List<TicketDto> ticketList = taskDto.getTickets();
        if (xyz.isPresent()) {
            if (ticketList != null) {
                for (TicketDto ticketDto : ticketList) {
                    TicketDto created = ticketServiceImpl.updateTicket(ticketDto.getId(), ticketDto);
                }
                Task updated = xyz.get();
                updated.setContent(taskDto.getContent());
                updated.setStartDate(taskDto.getStartDate());
                updated.setEndDate(taskDto.getEndDate());
                updated.setPriority(taskDto.getPriority());
                updated.setStatus(taskMapper.toTask(taskDto).getStatus());
                updated.setTickets(taskMapper.toTask(taskDto).getTickets());
                return taskMapper.toTaskDto(updated);
            } else {
                Task updated = xyz.get();
                updated.setContent(taskDto.getContent());
                updated.setStartDate(taskDto.getStartDate());
                updated.setEndDate(taskDto.getEndDate());
                updated.setPriority(taskDto.getPriority());
                updated.setStatus(taskMapper.toTask(taskDto).getStatus());
                updated.setTickets(taskMapper.toTask(taskDto).getTickets());
                return taskMapper.toTaskDto(updated);

            }
        } else throw new DocumentNotFoundException("No task provided for the given id");
    }

    /*============================ delete a task and also the tickets which are related to ========================================*/
    @Override
    public String deleteTask(String id) throws DocumentNotFoundException {
        Optional<Task> task = taskRepository.findById(id);
        List<TicketDto> ticketList = taskMapper.toTaskDto(task.get()).getTickets();
        if (task.isPresent()) {
            if (ticketList != null) {
                for (TicketDto ticketDto : ticketList) {
                    ticketServiceImpl.deleteTicket(ticketDto.getId());
                }
                taskRepository.deleteById(id);
                return "deleted successfully";
            } else {
                taskRepository.deleteById(id);
                return "deleted successfully";
            }
        } else throw new DocumentNotFoundException("No task found for the given id");
    }

    /*============================ get a task List ========================================*/
    @Override
    public List<TaskDto> getAll() {
        List<Task> taskList = taskRepository.findAll();
        List<TaskDto> taskDtoList = taskMapper.toTaskDtoList(taskList);
        if (taskDtoList.size() > 0) return taskDtoList;
        return new ArrayList<TaskDto>();
    }

}
