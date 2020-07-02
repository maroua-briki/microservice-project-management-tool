package com.bd.projManagement.repository;

import com.bd.projManagement.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {


}
