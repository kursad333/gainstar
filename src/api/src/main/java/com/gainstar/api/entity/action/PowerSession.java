package com.gainstar.api.entity.action;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PowerSession extends Session {
    private String name;

    @Enumerated(EnumType.STRING)
    private PowerGroup powerGroup;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PowerAction> exerciseList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerGroup getPowerGroup() {
        return powerGroup;
    }

    public void setPowerGroup(PowerGroup powerGroup) {
        this.powerGroup = powerGroup;
    }

    public List<PowerAction> getExerciseList() {
        return this.exerciseList;
    }

    public void setExerciseList(List<PowerAction> exerciseList) {
        this.exerciseList = exerciseList;
    }
}
