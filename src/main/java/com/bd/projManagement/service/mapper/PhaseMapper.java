package com.bd.projManagement.service.mapper;

import com.bd.projManagement.model.Phase;
import com.bd.projManagement.service.dto.PhaseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProjectMapper.class, TaskMapper.class})
public interface PhaseMapper {
    /*==================== to Dto ======================*/
    PhaseDto toPhaseDto(Phase phase);

    List<PhaseDto> toPhaseDtoList(List<Phase> taskList);

    /*===================== to Phase ============================*/
    Phase toPhase(PhaseDto phaseDto);

    List<Phase> toPhaseList(List<PhaseDto> phaseDtoList);
}
