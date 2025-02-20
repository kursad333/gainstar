package com.gainstar.api.entity.action;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PowerSession extends Session {
    private String name;

    @OneToMany
    private List<MuscleGroup> muscleGroupList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<PowerAction> exerciseList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MuscleGroup> getMuscleGroupList() {
        return muscleGroupList;
    }
    public void setMuscleGroupList(List<MuscleGroup> muscleGroupList) {
        this.muscleGroupList = muscleGroupList;
    }

    public List<PowerAction> getExerciseList() {
        return this.exerciseList;
    }

    public void setExerciseList(List<PowerAction> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public void addActionToList(PowerAction action) {
        this.exerciseList.add(action);
    }
}
