package com.bd.projManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bd.projManagement.model.Project;

public interface ProjectRepository extends MongoRepository<Project, Integer> {

}
