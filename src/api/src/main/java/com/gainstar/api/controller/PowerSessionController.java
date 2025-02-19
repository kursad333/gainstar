package com.gainstar.api.controller;


import com.gainstar.api.entity.action.MuscleGroup;
import com.gainstar.api.entity.action.PowerSession;
import com.gainstar.api.entity.action.PowerActionDTO;
import com.gainstar.api.entity.action.PowerSessionDTO;
import com.gainstar.api.service.MuscleGroupService;
import com.gainstar.api.service.PowerSessionService;
import com.gainstar.api.service.UserService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/power")
public class PowerSessionController {

    private final PowerSessionService powerSessionService;
    private final MuscleGroupService muscleGroupService;

    public PowerSessionController(PowerSessionService powerSessionService, MuscleGroupService muscleGroupService) {
        this.powerSessionService = powerSessionService;
        this.muscleGroupService = muscleGroupService;
    }

    @PostMapping("/session/create")
    public ResponseEntity<PowerSession> createPowerSession(@RequestBody PowerSessionDTO powerSessionDTO) {
        try {
            PowerSession created = this.powerSessionService.createPowerSession(powerSessionDTO);
            return ResponseEntity
                    .status(201)
                    .body(created);
        } catch (Exception e) {
            return ResponseEntity
                    .status(402)
                    .body(null);
        }
    }

    @PostMapping("/session/{id}/action")
    public ResponseEntity<PowerSession> addActionToSession(@RequestBody PowerActionDTO powerActionDTO, @PathVariable Long id) {
        PowerSession doesExist = this.powerSessionService.getPowerSession(id);
        if (doesExist != null) {
            PowerSession updated = this.powerSessionService.addActionToSession(doesExist, powerActionDTO);
            return ResponseEntity
                    .status(201)
                    .body(updated);
        } else {
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }

    @GetMapping("/session/{id}")
    public ResponseEntity<PowerSession> getPowerSession(@PathVariable String id) {
        PowerSession powerSession = this.powerSessionService.getPowerSession(Long.parseLong(id));
        if (powerSession != null) {
            return ResponseEntity
                    .status(200)
                    .body(powerSession);
        } else {
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }

    @GetMapping("/musclegroups")
    public ResponseEntity<List<MuscleGroup>> getMusclegroup() {
        List<MuscleGroup> muscleGroupList  = this.muscleGroupService.getAllMuscleGroups();
        if (muscleGroupList != null) {
            return ResponseEntity
                    .status(200)
                    .body(muscleGroupList);
        } else {
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }
}
