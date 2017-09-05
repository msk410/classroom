package com.poop.classroommanager.controllers;

import com.poop.classroommanager.models.Classroom;
import com.poop.classroommanager.repositories.ClassroomRepo;
import com.poop.classroommanager.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    ClassroomRepo classroomRepo;

    @Autowired
    ClassroomService classroomService;


    @GetMapping("/list")
    public Iterable<Classroom> getAll() {
        return this.classroomRepo.findAll();
    }
    @GetMapping("/{id}")
    public Classroom getOne(@PathVariable Long id) {
        return this.classroomRepo.findOne(id);
    }

    @PostMapping
    public ResponseEntity<Classroom> createOne(@RequestBody Classroom classroom) {
        this.classroomRepo.save(classroom);
        return new ResponseEntity<Classroom>(classroom, HttpStatus.OK);
    }

    @GetMapping("/test")
    public Classroom test() {
        return classroomRepo.findBySubject("calculus");
    }
}
