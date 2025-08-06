package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Prof;
import com.example.demo.repository.ProfRepository;
import com.example.demo.utils.ObjectUtils;

@Service("profService")
public class ProfServiceImpl implements IProfService {

	@Autowired
	private ProfRepository profRepo;

	private static final Logger logger = LogManager.getLogger(ProfServiceImpl.class);

	@Override
	public List<Prof> retreiveByNomAndPrenom(String nom, String prenom) {
		return profRepo.findByNomAndPrenom(nom, prenom);
	}

	@Override
	public List<Prof> retreiveByNomStartsWith(String prefix) {
		return profRepo.findByNomStartsWith(prefix);
	}

	@Override
	public Prof updateProfById(Long id, Prof profDetails) {
		Optional<Prof> existingProfOptional = profRepo.findById(id);

		if (existingProfOptional.isPresent()) {
			Prof existingProf = existingProfOptional.get();
			ObjectUtils.copyProperties(profDetails, existingProf);
			return profRepo.save(existingProf);
		} else {
			logger.warn("Professor with ID {} not found for update.", id);
			return null;
		}
	}

	@Override
	public void deleteProfById(Long id) {
		profRepo.deleteById(id);
	}
}