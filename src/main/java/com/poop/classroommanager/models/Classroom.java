package com.poop.classroommanager.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;

    private final int MAX_STUDENTS = 13;
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Student> students;

    private int numStudents;

    public Classroom(Long id, String subject, List<Student> students) {
        this.id = id;
        this.subject = subject;
        this.students = students;
    }

    public Classroom() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMAX_STUDENTS() {
        return MAX_STUDENTS;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents() {
        this.numStudents = this.students.size();
    }
}
