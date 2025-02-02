package com.gainstar.api.entity.action;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class PowerAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseSet> setList = new ArrayList<>();

    private Long rating;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public List<ExerciseSet> getSetList() {
        return setList;
    }

    public void setSetList(List<ExerciseSet> setList) {
        this.setList = setList;
    }

    public void addSetToList(ExerciseSet set) {
        this.setList.add(set);
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
