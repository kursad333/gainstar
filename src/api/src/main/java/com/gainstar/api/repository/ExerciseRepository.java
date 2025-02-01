package com.gainstar.api.repository;

import com.gainstar.api.entity.action.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
