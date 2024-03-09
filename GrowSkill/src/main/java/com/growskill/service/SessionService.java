package com.growskill.service;

import java.util.List;

import com.growskill.entity.Session;
import com.growskill.exceptoin.SessionException;

public interface SessionService {
	
	public List<Session> getAllSessions();
	
	public Session getSessionById(Long id) throws SessionException;
	
	public Session createSession(Session session);
	
	public Session updateSession(Long id,Session session) throws SessionException;
	
	public  boolean deleteSession(Long id) throws SessionException;
	
}
