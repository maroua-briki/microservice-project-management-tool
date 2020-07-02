package com.bd.projManagement.service.serviceImpl;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.model.Project;
import com.bd.projManagement.repository.ProjectRepository;
import com.bd.projManagement.service.ProjectService;
import com.bd.projManagement.service.dto.ProjectDto;
import com.bd.projManagement.service.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;

    /*============================ create a new project ========================================*/
    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        System.out.println("projectDto  " + projectDto);
        Project project = projectMapper.toProject(projectDto);
        System.out.println("project   " + project);
        Project createdProject = projectRepository.save(project);
        return projectMapper.toDto(createdProject);
    }

    /*============================ find a project with its id ========================================*/
    @Override
    public ProjectDto findProjectById(int id) throws DocumentNotFoundException {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            Project found = project.get();
            return projectMapper.toDto(found);
        } else throw new DocumentNotFoundException("No project found for the given id " + id);
    }

    /*============================ update a project ========================================*/
    @Override
    public ProjectDto updateProject(ProjectDto projectDto) throws DocumentNotFoundException {
        Optional<Project> project = projectRepository.findById(projectDto.getId());
        if (project.isPresent()) {
            Project updated = project.get();
            updated.setTopic(projectDto.getTopic());
            updated.setStartDate(projectDto.getStartDate());
            updated.setEndDate(projectDto.getEndDate());
            updated = projectRepository.save(updated);
            return projectMapper.toDto(updated);
        } else throw new DocumentNotFoundException("The project you want to update is not found ");

    }
    /*============================ delete project ========================================*/
    @Override
    public String deleteProject(int id) throws DocumentNotFoundException {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isPresent()){
            projectRepository.deleteById(id);
            return "deleted successfully";
        }else  throw new DocumentNotFoundException("No project found for the given id");
    }
    /*============================ get a list of projects ========================================*/
    @Override
    public List<ProjectDto> getProjects() {
        List<Project> projectList=projectRepository.findAll();
        List<ProjectDto> projectDtoList=projectMapper.toDtoList(projectList);
        if(projectList.size() >0) return projectDtoList;
        return new ArrayList<ProjectDto>();
    }

}
