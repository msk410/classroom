package com.poop.classroommanager.repositories;

import com.poop.classroommanager.models.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepo extends CrudRepository<Classroom, Long> {
    Classroom findBySubject(String subject);
}
