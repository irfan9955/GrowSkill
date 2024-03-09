package com.growskill.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growskill.entity.Session;
import com.growskill.exceptoin.SessionException;
import com.growskill.repository.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getSessionById(Long id) throws SessionException {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        return optionalSession.orElseThrow(() -> new SessionException("Session not found"));
    }

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session updateSession(Long id, Session session) throws SessionException {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        if (optionalSession.isPresent()) {
            session.setId(id); // Ensure the provided session ID matches the path variable
            return sessionRepository.save(session);
        } else {
            throw new SessionException("Session not found");
        }
    }

    @Override
    public boolean deleteSession(Long id) throws SessionException {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        if (optionalSession.isPresent()) {
            sessionRepository.deleteById(id);
            return true;
        } else {
            throw new SessionException("Session not found");
        }
    }
}
