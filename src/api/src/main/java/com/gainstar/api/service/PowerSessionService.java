package com.gainstar.api.service;

import com.gainstar.api.entity.action.PowerGroup;
import com.gainstar.api.entity.action.PowerSession;
import com.gainstar.api.repository.PowerSessionRepository;
import org.springframework.stereotype.Service;

@Service
public class PowerSessionService {

    private final PowerSessionRepository powerSessionRepository;

    public PowerSessionService(PowerSessionRepository powerSessionRepository ) {
        this.powerSessionRepository = powerSessionRepository;
    }

    public void createPowerSession(PowerSession powerSession) {
        this.powerSessionRepository.save(powerSession);
    }

    public PowerSession getPowerSession(Long id) {
        return this.powerSessionRepository.findById(id).orElse(null);
    }
}
