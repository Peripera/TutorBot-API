package com.tutorbot.service;

import com.tutorbot.model.Student;
import com.tutorbot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student registerStudent(Student s) {
        studentRepository.save(s);
        return s;
    }
}