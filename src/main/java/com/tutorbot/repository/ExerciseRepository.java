package com.tutorbot.repository;

import com.tutorbot.model.Exercise;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ExerciseRepository {
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseRepository() {
// EXercises generated with claude

        exercises.add(new Exercise(101, "Spring Boot", "What annotation marks a REST controller?", "easy", "@RestController"));
        exercises.add(new Exercise(102, "Java Core", "Which keyword is used to inherit a class?", "easy", "extends"));
        exercises.add(new Exercise(103, "Spring DI", "What annotation is used to inject a bean?", "medium", "@Autowired"));
        exercises.add(new Exercise(104, "Maven", "Which file is used to manage dependencies in Maven?", "hard", "pom.xml"));
        exercises.add(new Exercise(105, "SQL", "Which clause is used to filter records in a SELECT statement?", "easy", "WHERE"));
        exercises.add(new Exercise(106, "Docker", "What is the command to build an image from a Dockerfile?", "medium", "docker build"));
        exercises.add(new Exercise(107, "Java Streams", "Which method is used to transform elements in a stream?", "medium", "map"));
        exercises.add(new Exercise(108, "SQL", "Which window function is used to divide a result set into partitions?", "hard", "PARTITION BY"));
        exercises.add(new Exercise(109, "Linux", "Which command is used to change file permissions?", "easy", "chmod"));
        exercises.add(new Exercise(110, "Spring Security", "Which annotation is used to secure a specific method?", "hard", "@PreAuthorize"));
    }

    public List<Exercise> findAll() {
        return exercises;
    }

    public Exercise findById(int id) {
        return exercises.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Exercise> findByDifficulty(String difficulty) {
        return exercises.stream()
                .filter(e -> e.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());
    }
}