package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Prof;

public interface IProfService {
	List<Prof> retreiveByNomAndPrenom(String nom, String prenom);

	List<Prof> retreiveByNomStartsWith(String prefix);

	Prof updateProfById(Long id, Prof profDetails);

	void deleteProfById(Long id);
}
