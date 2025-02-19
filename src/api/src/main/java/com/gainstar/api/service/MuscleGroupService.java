package com.gainstar.api.service;

import com.gainstar.api.entity.action.MuscleGroup;
import com.gainstar.api.repository.MuscleGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleGroupService {

    private final MuscleGroupRepository muscleGroupRepository;

    public MuscleGroupService(MuscleGroupRepository muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    public List<MuscleGroup> getAllMuscleGroups() {
        return muscleGroupRepository.findAll();
    }

}
