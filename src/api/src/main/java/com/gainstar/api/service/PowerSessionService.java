package com.gainstar.api.service;

import com.gainstar.api.entity.action.*;
import com.gainstar.api.repository.ExerciseRepository;
import com.gainstar.api.repository.PowerSessionRepository;
import com.gainstar.api.util.EnumValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSessionService {

    private final PowerSessionRepository powerSessionRepository;
    private final ExerciseService exerciseService;

    public PowerSessionService(PowerSessionRepository powerSessionRepository, ExerciseService exerciseService ) {
        this.powerSessionRepository = powerSessionRepository;
        this.exerciseService = exerciseService;
    }

    public PowerSession createPowerSession(PowerSessionDTO powerSessionDTO) {
        try {
            PowerSession powerSession = new PowerSession();
            powerSession.setUserId(powerSessionDTO.userId());
            powerSession.setName(powerSessionDTO.name());
            // Check if the power group is valid
            if (EnumValidator.isValidPowerGroup(powerSessionDTO.group())) {
                powerSession.setPowerGroup(PowerGroup.valueOf(powerSessionDTO.group()));
            } else {
                throw new IllegalArgumentException("Invalid power group");
            }
            powerSession.setStartTime(powerSessionDTO.startTime());
            powerSession.setEndTime(powerSessionDTO.endTime());
            powerSession.setType("Power");

            powerSessionDTO.actions().forEach(action -> {
                PowerAction powerAction = createPowerAction(action);
                powerSession.addActionToList(powerAction);
            });

            return this.powerSessionRepository.save(powerSession);

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid power session");
        }
    }

    public PowerSession addActionToSession(PowerSession powerSession, PowerSessionActionDTO powerSessionActionDTO) {
        if (powerSession.getExerciseList().contains(powerSessionActionDTO.exerciseId())) {
            throw new IllegalArgumentException("Exercise already exists in the session");
        }

        PowerAction powerAction = createPowerAction(powerSessionActionDTO);
        powerSession.addActionToList(powerAction);
        return this.powerSessionRepository.save(powerSession);
    }

    private PowerAction createPowerAction(PowerSessionActionDTO powerSessionActionDTO) {
        PowerAction powerAction = new PowerAction();

        // Make sure this fetches the exercise from the DB
        Exercise exercise = this.exerciseService.getExerciseById(powerSessionActionDTO.exerciseId());

        // Ensure the exercise is managed by the persistence context
        if (exercise == null) {
            throw new IllegalArgumentException("Exercise with ID " + powerSessionActionDTO.exerciseId() + " not found");
        }

        powerAction.setExercise(exercise);

        if (powerSessionActionDTO.sets() == null) {
            return powerAction;
        }

        powerSessionActionDTO.sets().forEach(set -> {
            ExerciseSet exerciseSet = new ExerciseSet();
            exerciseSet.setReps(set.getReps());
            exerciseSet.setWeight(set.getWeight());
            powerAction.addSetToList(exerciseSet);
        });

        powerAction.setRating(powerSessionActionDTO.rating());

        return powerAction;
    }


    public PowerSession getPowerSession(Long id) {
        return this.powerSessionRepository.findById(id).orElse(null);
    }

    public void updatePowerSession(PowerSession powerSession) {
        PowerSession a = this.powerSessionRepository.findById(powerSession.getId()).orElse(null);
        if(a != null) {
            this.powerSessionRepository.save(powerSession);
        }

    }
}
