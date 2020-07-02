package com.bd.projManagement.controller;

import com.bd.projManagement.exception.DocumentNotFoundException;
import com.bd.projManagement.service.dto.PhaseDto;
import com.bd.projManagement.service.serviceImpl.PhaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/phases")
@RestController
@CrossOrigin("*")

public class PhaseController {

    @Autowired
    PhaseServiceImpl phaseService;

    @PostMapping("/create")
    PhaseDto create(@RequestBody PhaseDto phaseDto) {
        return phaseService.createPhase(phaseDto);
    }

    @GetMapping("/{id}")
    PhaseDto getOne(@PathVariable String id) throws DocumentNotFoundException {
        return phaseService.findPhaseById(id);
    }

    @PutMapping("/update/{id}")
    PhaseDto update(@PathVariable String id, @RequestBody PhaseDto phaseDto) {
        return phaseService.updatePhase(id, phaseDto);
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable String id) {
        return phaseService.deletePhase(id);
    }

    @GetMapping
    List<PhaseDto> getAll() {
        return phaseService.getAllPhases();
    }

    @GetMapping("/byProject/{id}")
    List<PhaseDto> getPh(@PathVariable String id){
        return phaseService.getPhasesByProject(id);
    }

    @DeleteMapping("/delete/all")
    String deleteAll(){
        return phaseService.deleteAllPhases();
    }
    @DeleteMapping("/delete/{id}")
    String deleteElement(@PathVariable String id){
        return phaseService.deletePhase(id) ;   }
}
