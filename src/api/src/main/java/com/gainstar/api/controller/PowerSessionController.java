package com.gainstar.api.controller;


import com.gainstar.api.entity.action.PowerSession;
import com.gainstar.api.entity.action.PowerActionDTO;
import com.gainstar.api.entity.action.PowerSessionDTO;
import com.gainstar.api.service.PowerSessionService;
import com.gainstar.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/power")
public class PowerSessionController {

    private final PowerSessionService powerSessionService;

    public PowerSessionController(PowerSessionService powerSessionService) {
        this.powerSessionService = powerSessionService;
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
}
