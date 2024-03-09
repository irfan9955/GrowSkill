package com.growskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growskill.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
