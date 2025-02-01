package com.gainstar.api.service;

import com.gainstar.api.entity.action.Exercise;
import com.gainstar.api.repository.ExerciseRepository;
import org.springframework.stereotype.Component;

@Component
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }
}
