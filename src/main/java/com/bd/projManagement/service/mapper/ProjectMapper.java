package com.bd.projManagement.service.mapper;


import com.bd.projManagement.model.Project;
import com.bd.projManagement.service.dto.ProjectDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;


//@Mapper
//@Mapper(componentModel = "spring", uses=ProjectMapper.class,injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Mapper(componentModel = "spring")
public interface ProjectMapper {

	/*==================== to Dto ======================*/
	ProjectDto toDto(Project project);
	List<ProjectDto> toDtoList(List<Project> projectList);
	/*===================== to Project ============================*/
	Project toProject(ProjectDto projectDto);
	List<Project> toProjectList(List<ProjectDto> projectDtoList);

}
