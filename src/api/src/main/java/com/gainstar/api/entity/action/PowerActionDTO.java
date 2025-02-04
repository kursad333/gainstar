package com.gainstar.api.entity.action;

import java.util.List;

public record PowerActionDTO(
        Long exerciseId,
        List<ExerciseSet> sets,
        Long rating
) {
    public PowerActionDTO {
        if (sets == null) {
            sets = List.of();
        }
    }
}
