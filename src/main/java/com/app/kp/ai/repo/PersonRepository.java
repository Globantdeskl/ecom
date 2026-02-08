package com.app.kp.ai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kp.ai.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
