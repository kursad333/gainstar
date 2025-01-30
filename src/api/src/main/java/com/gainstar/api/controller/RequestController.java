package com.gainstar.api.controller;

import com.gainstar.api.entity.action.*;
import com.gainstar.api.service.PowerSessionService;
import com.gainstar.api.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.Long.parseLong;

@RestController
public class RequestController {

    private final PowerSessionService powerSessionService;
    private final SessionService sessionService;

    @GetMapping("/api")
    public String getApi() {
        return "Hello from a bloated Java framework";
    }

    public RequestController(PowerSessionService powerSessionService, SessionService sessionService) {
        this.powerSessionService = powerSessionService;
        this.sessionService = sessionService;
    }

    @PutMapping("/api/power-session")
    public void createPowerSession() {
        // Create a power session
        PowerSession powerSession = new PowerSession();

        powerSession.setUserId(1L);
        powerSession.setStartTime(LocalDateTime.of(2021, 1, 1, 12, 0));
        powerSession.setEndTime(LocalDateTime.of(2021, 1, 1, 13, 0));
        powerSession.setType("Power");
        powerSession.setName("Chest day pa");
        powerSession.setPowerGroup(PowerGroup.CHEST);

        // Create exercise
        Exercise exercise = new Exercise();
        exercise.setName("Bench press");

        // Create power action
        PowerAction powerAction = new PowerAction();
        powerAction.setExercise(exercise);

        // Create exercise sets
        ExerciseSet exerciseSet1 = new ExerciseSet();
        exerciseSet1.setReps(10L);
        exerciseSet1.setWeight(100.0);

        ExerciseSet exerciseSet2 = new ExerciseSet();
        exerciseSet2.setReps(10L);
        exerciseSet2.setWeight(100.0);

        // Associate exercise sets with power action
        powerAction.setSetList(List.of(exerciseSet1, exerciseSet2));

        // Associate power action with power session
        powerSession.setExerciseList(List.of(powerAction));

        // Persist power session (cascades will persist child entities)
        this.powerSessionService.createPowerSession(powerSession);
    }

    @GetMapping("/api/power-session/{id}")
    public ResponseEntity<PowerSession> getPowerSession(@PathVariable String id) {
        PowerSession test = this.powerSessionService.getPowerSession(parseLong(id));
        return ResponseEntity.status(200).body(test);
    }


}
