package com.poop.classroommanager.controllers;

import com.poop.classroommanager.models.Classroom;
import com.poop.classroommanager.models.Student;
import com.poop.classroommanager.repositories.ClassroomRepo;
import com.poop.classroommanager.repositories.StudentRepo;
import com.poop.classroommanager.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    ClassroomRepo classroomRepo;

    @Autowired
    ClassroomService classroomService;

    @GetMapping("/list")
    public Iterable<Student> getAll() {
        return this.studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Long id) {
        return this.studentRepo.findOne(id);
    }

    @PostMapping
    public ResponseEntity<Student> createOne(@RequestBody Student student) {

        return classroomService.addStudent(student);
        }


}
