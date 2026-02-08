package com.app.kp.ai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.kp.ai.model.PlanetEffect;

public interface PlanetEffectRepository extends JpaRepository<PlanetEffect, Long> {

	List<PlanetEffect> findByDomainAndActiveTrue(String domain);
}
