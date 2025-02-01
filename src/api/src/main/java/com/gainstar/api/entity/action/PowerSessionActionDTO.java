package com.gainstar.api.entity.action;

import java.util.List;

public record PowerSessionActionDTO(
        Long exerciseId,
        List<ExerciseSet> sets
) {
    public PowerSessionActionDTO {
        if (sets == null) {
            sets = List.of();
        }
    }
}
