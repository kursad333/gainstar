package com.gainstar.api.factory;

import com.gainstar.api.entity.action.*;
import com.gainstar.api.service.ExerciseService;
import com.gainstar.api.util.EnumValidator;
import org.springframework.stereotype.Component;

@Component
public class PowerFactory {

    private final ExerciseService exerciseService;

    public PowerFactory(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    public PowerSession createPowerSession(PowerSessionDTO powerSessionDTO) {
        System.out.printf(powerSessionDTO.toString());
        PowerSession powerSession = new PowerSession();
        powerSession.setUserId(powerSessionDTO.userId());
        powerSession.setName(powerSessionDTO.name());

        powerSession.setMuscleGroupList(powerSessionDTO.group());

        powerSession.setStartTime(powerSessionDTO.startTime());
        powerSession.setEndTime(powerSessionDTO.endTime());
        powerSession.setType("Power");

        powerSessionDTO.actions().forEach(action -> {
            PowerAction powerAction = createPowerAction(action);
            powerSession.addActionToList(powerAction);
        });

        return powerSession;
    }

    public PowerAction createPowerAction(PowerActionDTO powerActionDTO) {
        PowerAction powerAction = new PowerAction();

        Exercise exercise = this.exerciseService.getExerciseById(powerActionDTO.exerciseId());
        if (exercise == null) {
            throw new IllegalArgumentException("Exercise with ID " + powerActionDTO.exerciseId() + " not found");
        }

        powerAction.setExercise(exercise);
        if (powerActionDTO.sets() == null) {
            return powerAction;
        }

        powerActionDTO.sets().forEach(set -> {
            ExerciseSet exerciseSet = new ExerciseSet();
            exerciseSet.setReps(set.getReps());
            exerciseSet.setWeight(set.getWeight());
            powerAction.addSetToList(exerciseSet);
        });
        powerAction.setRating(powerActionDTO.rating());
        return powerAction;
    }

}
