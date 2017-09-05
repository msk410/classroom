package com.poop.classroommanager.repositories;

import com.poop.classroommanager.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
