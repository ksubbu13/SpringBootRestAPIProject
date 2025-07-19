package com.example.restapi.controller;

import com.example.restapi.entity.Student;
import com.example.restapi.repository.StudentRepo;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCtrl {
    @Autowired
    StudentRepo repo;
    //to get all the students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }
    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        return student;
    }
    //localhost:8080/students/add
    @PostMapping("/students/add")
    // response will get 201 ststus code for created record. without this line will show 200 sucess
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createstudent(@RequestBody Student student){
        repo.save(student);
    }
    //localhost:8080/students/update
    @PutMapping("/students/update/{id}")
    public Student updateStudents(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("Rani");
        student.setPercentage(99);
        repo.save(student);
        return student;
    }
    //localhost:8080/students/delete/6
    @DeleteMapping("/students/delete/{id}")
    public void removeStudents(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
    }

}
