package com.poop.classroommanager.services;

import com.poop.classroommanager.models.Classroom;
import com.poop.classroommanager.models.Student;
import com.poop.classroommanager.repositories.ClassroomRepo;
import com.poop.classroommanager.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepo classroomRepo;

    @Autowired
    StudentRepo studentRepo;

    public ResponseEntity<Student> addStudent(Student student) {
        Student s = this.studentRepo.save(student);
        Long classId = student.getClassroom().getId();
        ResponseEntity<Student> responseEntity;

        Classroom c = this.classroomRepo.findOne(classId);
        if (c.getNumStudents() < c.getMAX_STUDENTS()) {
            System.out.println("im a teapot" + c.getMAX_STUDENTS() + " " + c.getNumStudents());
            this.classroomRepo.save(c);
            c.setNumStudents();
            this.studentRepo.save(s);
            responseEntity = new ResponseEntity<>(s, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<Student>(s, HttpStatus.I_AM_A_TEAPOT);
        }
        return responseEntity;
    }
}
