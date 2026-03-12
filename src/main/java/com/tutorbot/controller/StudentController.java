package com.tutorbot.controller;

import com.tutorbot.model.Student;
import com.tutorbot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student register(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }
}