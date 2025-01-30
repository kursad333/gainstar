package com.gainstar.api.repository;

import com.gainstar.api.entity.action.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
