package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growskill.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

}
