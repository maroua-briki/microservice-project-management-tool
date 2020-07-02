package com.bd.projManagement.service;
import java.util.Collection;
import java.util.List;

import com.bd.projManagement.service.dto.ProjectDto;

public interface ProjectService {

    public abstract ProjectDto createProject(ProjectDto projectDto);

    public abstract ProjectDto findProjectById(int id);

    public abstract ProjectDto updateProject(ProjectDto projectDto);

    public abstract String deleteProject(int id);

    public abstract List<ProjectDto> getProjects();


}
