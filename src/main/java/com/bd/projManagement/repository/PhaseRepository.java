package com.bd.projManagement.repository;

import com.bd.projManagement.model.Phase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhaseRepository extends MongoRepository<Phase, String> {

    List<Phase> findPhaseByProjectId(String id);

}
