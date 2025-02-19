package com.gainstar.api.entity.action;

import java.time.LocalDateTime;
import java.util.List;

public record PowerSessionDTO(
        Long userId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String name,
        List<MuscleGroup> group,
        List<PowerActionDTO> actions
) {
    public PowerSessionDTO {
        if (actions == null) {
            actions = List.of(); // Ensure it's always non-null
        }
        if (group == null) {
            group = List.of(); // Ensure it's always non-null
        }
    }
}
