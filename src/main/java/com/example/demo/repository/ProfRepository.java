package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Prof;

public interface ProfRepository extends JpaRepository<Prof, Long> {
	public List<Prof> findByNomAndPrenom(String nom, String prenom);

	@Query("SELECT p FROM Prof p WHERE LOWER(p.nom) LIKE LOWER(CONCAT(:prefix, '%'))")
	List<Prof> findByNomStartsWith(String prefix);
}
