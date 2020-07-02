package com.bd.projManagement.service;

import com.bd.projManagement.service.dto.PhaseDto;

import java.util.List;

public interface PhaseService {

    PhaseDto createPhase(PhaseDto phaseDto);

    PhaseDto findPhaseById(String id);

    PhaseDto updatePhase(String id, PhaseDto phaseDto);

    String deletePhase(String id);

    List<PhaseDto> getAllPhases();

    List<PhaseDto> getPhasesByProject(String id);

    String deleteAllPhases();
}
