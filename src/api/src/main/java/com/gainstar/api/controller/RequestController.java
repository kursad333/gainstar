package com.gainstar.api.controller;

import com.gainstar.api.entity.action.*;
import com.gainstar.api.service.PowerSessionService;
import com.gainstar.api.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/api/v1/session")
public class RequestController {

    private final PowerSessionService powerSessionService;
    private final SessionService sessionService;

    @GetMapping("/")
    public String getApi() {
        return "Hello from a bloated Java framework";
    }

    public RequestController(PowerSessionService powerSessionService, SessionService sessionService) {
        this.powerSessionService = powerSessionService;
        this.sessionService = sessionService;
    }

    @PutMapping("/power")
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

    @PutMapping("/power/set/{id}")
    public ResponseEntity<ExerciseSet> addExerciseSet(@PathVariable Long id) {
        ExerciseSet exerciseSet1 = new ExerciseSet();
        exerciseSet1.setReps(8L);
        exerciseSet1.setWeight(20.0);

        ExerciseSet exerciseSet2 = new ExerciseSet();
        exerciseSet2.setReps(4L);
        exerciseSet2.setWeight(22.0);


        PowerSession powerSession = this.powerSessionService.getPowerSession(1L);
        List<PowerAction> exerciseList = powerSession.getExerciseList();

// Ensure the exercise list is initialized
        if (exerciseList == null) {
            exerciseList = new ArrayList<>();
            powerSession.setExerciseList(exerciseList);
        }

// Find an existing PowerAction or create a new one
        PowerAction powerAction;
        if (!exerciseList.isEmpty()) {
            powerAction = exerciseList.get(0); // Pick an existing one
        } else {
            powerAction = new PowerAction();
            powerAction.setSetList(new ArrayList<>()); // Initialize set list
            exerciseList.add(powerAction);
        }

        List<PowerAction> powerActions = powerSession.getExerciseList();
//        powerActions.

// Add the set to the PowerAction
//        powerAction.getSetList().add(exerciseSet1);
//        powerAction.getSetList().add(exerciseSet2);

// Save the updated PowerSession
        this.powerSessionService.updatePowerSession(powerSession);

        return ResponseEntity.ok(exerciseSet1);
    }

    @GetMapping("/power/{id}")
    public ResponseEntity<Session> getPowerSession(@PathVariable String id) {
        PowerSession test = this.powerSessionService.getPowerSession(parseLong(id));
        Session test2 = this.sessionService.getSession(parseLong(id));
        return ResponseEntity.status(200).body(test2);
    }

    //TODO:
    // Ideally we want a structure like this:
    // SessionController.class
    // function getSession URL/api/session/{type}/{id}
    // switch (type)
    // if session type = power
    // return PowerSessionController.functionName(id)
    // if session type = cardio
    // return CardioSessionController.functionName(id)
    // along with correct error handling in the SessionController itself
    // this way we can leverage each controller for a specific session type
    // keeping the SessionController clean and concise and easy to maintain
}
