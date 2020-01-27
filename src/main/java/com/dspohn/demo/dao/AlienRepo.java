package com.dspohn.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dspohn.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAlienIDGreaterThan(int alienID);
	
	@Query("from Alien where tech=?1 order by alienName")
	List<Alien> findByTechSorted(String tech);
	
} 