package com.bd.projManagement.service.serviceImpl;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.model.Phase;
import com.bd.projManagement.repository.PhaseRepository;
import com.bd.projManagement.repository.TaskRepository;
import com.bd.projManagement.service.PhaseService;
import com.bd.projManagement.service.dto.PhaseDto;
import com.bd.projManagement.service.dto.TaskDto;
import com.bd.projManagement.service.mapper.PhasesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhaseServiceImpl implements PhaseService {

    @Autowired
    PhasesMapper phaseMapper;
    @Autowired
    TaskServiceImpl taskService;
    @Autowired
    PhaseRepository phaseRepository;
    @Autowired
    PhaseServiceImpl phaseService;
    @Autowired
    TaskRepository taskRepository;

    /*============================ create a new task and its ticket concerns ========================================*/
    @Override
    public PhaseDto createPhase(PhaseDto phaseDto) {
        System.out.println("phaseDto " + phaseDto);
        System.out.println("beginning : "+phaseDto.getProject());
        List<TaskDto> taskDtoList = phaseDto.getTasks();
        if (taskDtoList != null) {
            for (TaskDto taskDto : taskDtoList) {
                TaskDto created = taskService.createTask(taskDto);
            }
            Phase phase = phaseMapper.toPhase(phaseDto);
            Phase createdPhase = phaseRepository.insert(phase);
            return phaseMapper.toPhaseDto(createdPhase);
        } else {
            System.out.println("hello I am in else");
            Phase phase = phaseMapper.toPhase(phaseDto);
            System.out.println("phase "+phase);
            Phase createdPhase = phaseRepository.save(phase);
            System.out.println("createdPhase "+ createdPhase);
            return phaseMapper.toPhaseDto(createdPhase);
        }
    }

    /*============================ get a phase by id ========================================*/
    @Override
    public PhaseDto findPhaseById(String id) throws DocumentNotFoundException {
        Optional<Phase> phase = phaseRepository.findById(id);
        if (phase.isPresent()) {
            Phase found = phase.get();
            return phaseMapper.toPhaseDto(found);
        } else throw new DocumentNotFoundException("No phase provided for the given id");
    }

    /*============================ update a phase ========================================*/
    @Override
    public PhaseDto updatePhase(String id, PhaseDto phaseDto) {

        Optional<Phase> phase = phaseRepository.findById(id);
        List<TaskDto> taskDtoList = phaseDto.getTasks();
        if (phase.isPresent()) {
            if (taskDtoList != null) {
                for (TaskDto taskDto : taskDtoList) taskService.updateTask(taskDto.getId(), taskDto);
                Phase updated = phase.get();
                updated.setPhaseLabel(phaseDto.getPhaseLabel());
                updated.setStartDate(phaseDto.getStartDate());
                updated.setEndDate(phaseDto.getEndDate());
                updated.setTasks(phaseMapper.toPhase(phaseDto).getTasks());
                updated=phaseRepository.save(updated);
                return phaseMapper.toPhaseDto(updated);
            } else {
                Phase updated = phase.get();
                System.out.println("the new phase label "+phaseDto.getPhaseLabel());
                updated.setPhaseLabel(phaseDto.getPhaseLabel());
                System.out.println("updated"+updated.getPhaseLabel());
                updated.setStartDate(phaseDto.getStartDate());
                updated.setEndDate(phaseDto.getEndDate());
                updated.setTasks(phaseMapper.toPhase(phaseDto).getTasks());
                System.out.println("up end"+updated);
                updated=phaseRepository.save(updated);

                return phaseMapper.toPhaseDto(updated);
            }
        } else throw new DocumentNotFoundException("No phase provided for the given id");
    }
    /*============================ delete a phase and also the tasks which are related to ========================================*/

    @Override
    public String deletePhase(String id) throws DocumentNotFoundException {
        Optional<Phase> phase = phaseRepository.findById(id);
        List<TaskDto> taskDtoList = phaseMapper.toPhaseDto(phase.get()).getTasks();
        if (phase.isPresent()) {
            if (taskDtoList != null) {
                for (TaskDto taskDto : taskDtoList) taskService.deleteTask(taskDto.getId());
                phaseRepository.deleteById(id);
                return "deleted successfully";
            } else {
                phaseRepository.deleteById(id);
                return "deleted successfully";
            }
        } else throw new DocumentNotFoundException("No phase provided for the given id");
    }

    /*============================ get all phases   ========================================*/
    @Override
    public List<PhaseDto> getAllPhases() {
        List<PhaseDto> phaseDtoList = phaseMapper.toPhaseDtoList(phaseRepository.findAll());
        if (phaseDtoList.size() > 0) return phaseDtoList;
        return new ArrayList<PhaseDto>();
    }
    /*============================ find phases by project id   ========================================*/

    @Override
    public List<PhaseDto> getPhasesByProject(String id) {
        List<Phase> phases = phaseRepository.findPhaseByProjectId(id);
        System.out.println("phases"+phases);
        return phaseMapper.toPhaseDtoList(phases);


    }

    @Override
    public String deleteAllPhases() {
        phaseRepository.deleteAll();
        return "deleted";
    }


}
