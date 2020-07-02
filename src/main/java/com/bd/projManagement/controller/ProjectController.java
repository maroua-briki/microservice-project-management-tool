package com.bd.projManagement.controller;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.service.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bd.projManagement.service.dto.ProjectDto;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectServiceImpl;

	@PostMapping("/create")
	ProjectDto create(@RequestBody ProjectDto projectDto) {
		return projectServiceImpl.createProject(projectDto);
	}

	@GetMapping("/{id}")
	ProjectDto getOne(@PathVariable("id") int id) throws DocumentNotFoundException {
		return projectServiceImpl.findProjectById(id);
	}
	@PutMapping("/update/{id}")
	ProjectDto update(@PathVariable("id") int id) throws DocumentNotFoundException{
	ProjectDto projectToUpdate=projectServiceImpl.findProjectById(id);
		return projectServiceImpl.updateProject(projectToUpdate);
	}

	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable("id") int id) throws DocumentNotFoundException{
        return projectServiceImpl.deleteProject(id);
	}
	@GetMapping
	List<ProjectDto> getAll(){
		return projectServiceImpl.getProjects();
	}
}
