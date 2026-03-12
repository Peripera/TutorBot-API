package com.tutorbot.repository;

import com.tutorbot.model.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        // Pre-carga de 10 estudiantes para la simulación
        students.add(new Student(1, "Ana Torres", "ana@university.com", "beginner"));
        students.add(new Student(2, "Luis Paez", "luis@university.com", "intermediate"));
        students.add(new Student(3, "Sofia Glass", "sofia@university.com", "advanced"));
        students.add(new Student(4, "Carlos Ruiz", "carlos@university.com", "beginner"));
        students.add(new Student(5, "Elena Marín", "elena@university.com", "intermediate"));
        students.add(new Student(6, "Diego Sosa", "diego@university.com", "advanced"));
        students.add(new Student(7, "Laura Peña", "laura@university.com", "beginner"));
        students.add(new Student(8, "Andrés Soto", "andres@university.com", "intermediate"));
        students.add(new Student(9, "Beatriz Luna", "beatriz@university.com", "advanced"));
        students.add(new Student(10, "Jorge Vera", "jorge@university.com", "beginner"));
    }

    // Retorna todos los estudiantes
    public List<Student> findAll() {
        return students;
    }

    // Busca un estudiante por su ID usando Streams de Java
    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Guarda un nuevo estudiante y le asigna un ID automático
    public void save(Student s) {
        int nextId = students.isEmpty() ? 1 : students.get(students.size() - 1).getId() + 1;
        s.setId(nextId);
        students.add(s);
    }
}