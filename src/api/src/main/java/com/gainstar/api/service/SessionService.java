package com.gainstar.api.service;

import com.gainstar.api.entity.action.Session;
import com.gainstar.api.repository.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session getSession(Long id) {
        return this.sessionRepository.findById(id).orElse(null);
    }
}
