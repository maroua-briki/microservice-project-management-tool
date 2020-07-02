package com.bd.projManagement.repository;

import com.bd.projManagement.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
