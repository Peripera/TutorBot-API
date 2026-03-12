package com.tutorbot.controller;

import com.tutorbot.model.Exercise;
import com.tutorbot.model.Feedback;
import com.tutorbot.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public List<Exercise> getExercises(@RequestParam(required = false) String difficulty) {
        if (difficulty != null) {
            return exerciseService.getExercisesByDifficulty(difficulty);
        }
        return exerciseService.getAllExercises();
    }

    @PostMapping("/submit")
    public Feedback submit(@RequestBody Map<String, Object> payload) {
        int studentId = (int) payload.get("studentId");
        int exerciseId = (int) payload.get("exerciseId");
        String answer = (String) payload.get("answer");
        
        return exerciseService.submitAnswer(studentId, exerciseId, answer);
    }
}