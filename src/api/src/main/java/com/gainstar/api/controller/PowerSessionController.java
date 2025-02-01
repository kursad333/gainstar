package com.gainstar.api.controller;


import com.gainstar.api.entity.action.PowerSession;
import com.gainstar.api.entity.action.PowerSessionDTO;
import com.gainstar.api.service.PowerSessionService;
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

    @GetMapping("/session/{id}")
    public ResponseEntity<PowerSessionDTO> getPowerSession(@PathVariable String id) {
        return null;
    }
}
