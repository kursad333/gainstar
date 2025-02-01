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
            powerSession.setStartTime(powerSessionDTO.endTime());
            powerSession.setEndTime(powerSessionDTO.startTime());
            powerSession.setType("Power");


            if (powerSessionDTO.actions() != null) {
                powerSessionDTO.actions().forEach(action -> {
                    // Create exercise
                    Exercise exercise = this.exerciseService.getExerciseById(action.exerciseId());
                    if (exercise == null) {
                        throw new IllegalArgumentException("Invalid exercise");
                    }

                    // Create power action
                    PowerAction powerAction = new PowerAction();
                    powerAction.setExercise(exercise);
                    powerSession.setExerciseList(List.of(powerAction));
                });
            }

            return this.powerSessionRepository.save(powerSession);

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid power session");
        }
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
