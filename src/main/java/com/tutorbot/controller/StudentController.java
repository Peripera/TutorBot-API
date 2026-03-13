package com.tutorbot.controller;

import com.tutorbot.model.Feedback;
import com.tutorbot.model.Student;
import com.tutorbot.service.ExerciseService;
import com.tutorbot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExerciseService exerciseService;

    

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id) {
        Student s = studentService.getStudentById(id);
        if (s == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Student not found", "id_requested", id));
        }
        return ResponseEntity.ok(s);
    }

    @GetMapping("/{id}/feedback")
    public ResponseEntity<List<Feedback>> getStudentFeedback(@PathVariable int id) {
        List<Feedback> feedbacks = exerciseService.getFeedbacksByStudent(id);
        return ResponseEntity.ok(feedbacks);
    }


 
    @PostMapping
    public Student register(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }
}