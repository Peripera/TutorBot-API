package com.tutorbot.service;

import com.tutorbot.model.Exercise;
import com.tutorbot.model.Feedback;
import com.tutorbot.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    private List<Feedback> allFeedbacks = new ArrayList<>();

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getExercisesByDifficulty(String difficulty) {
        return exerciseRepository.findByDifficulty(difficulty);
    }

    public Feedback submitAnswer(int studentId, int exerciseId, String answer) {
        Exercise exercise = exerciseRepository.findById(exerciseId);
        
        if (exercise == null) return null;

        // Comparamos la respuesta
        boolean isCorrect = exercise.getCorrectAnswer().trim().equalsIgnoreCase(answer.trim());
        
        int score = isCorrect ? 100 : 40;
        String message = isCorrect ? "Excellent! On spot." : "Keep practicing! You can do better next time.";

        Feedback fb = new Feedback(studentId, exerciseId, answer, score, message, isCorrect);

        // GUARDAMOS el feedback en nuestra lista global
        allFeedbacks.add(fb);
        
        return fb;

    }

    public List<Feedback> getFeedbacksByStudent(int studentId) {
        return allFeedbacks.stream()
                .filter(f -> f.getStudentId() == studentId)
                .collect(Collectors.toList());
    }
}