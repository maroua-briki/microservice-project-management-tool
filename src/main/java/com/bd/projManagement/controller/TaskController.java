package com.bd.projManagement.controller;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.service.dto.TaskDto;
import com.bd.projManagement.service.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("*")

public class TaskController {
    @Autowired
    TaskServiceImpl taskServiceImpl;

    @PostMapping("/create")
    TaskDto create(@RequestBody TaskDto taskDto) {
        return taskServiceImpl.createTask(taskDto);
    }

    @GetMapping("/{id}")
    TaskDto getOne(@PathVariable String id) throws DocumentNotFoundException {
        return taskServiceImpl.findTaskById(id);
    }

    @PutMapping("/update/{id}")
    TaskDto update(@PathVariable String id, @RequestBody TaskDto taskDto) {
        return taskServiceImpl.updateTask(id, taskDto);
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable String id) {
        return taskServiceImpl.deleteTask(id);
    }

    @GetMapping
    List<TaskDto> getAll() {
        return taskServiceImpl.getAll();
    }

}
