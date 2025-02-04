package com.gainstar.api.service;

import com.gainstar.api.entity.action.*;
import com.gainstar.api.factory.PowerFactory;
import com.gainstar.api.repository.PowerSessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PowerSessionService {

    private final PowerSessionRepository powerSessionRepository;
    private final PowerFactory powerFactory;

    public PowerSessionService(PowerSessionRepository powerSessionRepository, PowerFactory powerFactory) {
        this.powerSessionRepository = powerSessionRepository;
        this.powerFactory = powerFactory;
    }

    public PowerSession createPowerSession(PowerSessionDTO powerSessionDTO) {
        try {
            PowerSession powerSession = this.powerFactory.createPowerSession(powerSessionDTO);
            return this.powerSessionRepository.save(powerSession);
        } catch (Exception e) {
            return null;
        }
    }

    public PowerSession addActionToSession(PowerSession powerSession, PowerActionDTO powerActionDTO) {
        try {
            PowerAction powerAction = this.powerFactory.createPowerAction(powerActionDTO);
            powerSession.addActionToList(powerAction);
            return this.powerSessionRepository.save(powerSession);

            //TODO: if exerciseId is already in Session, use (create) updateFunction()
        } catch (Exception e) {
            return null;
        }
    }

    public PowerSession getPowerSession(Long id) {
        try {
            return this.powerSessionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Session not found"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
