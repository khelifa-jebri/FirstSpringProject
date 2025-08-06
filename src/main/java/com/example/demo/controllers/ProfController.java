package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Prof;
import com.example.demo.repository.ProfRepository;
import com.example.demo.services.IProfService;

@RestController
@RequestMapping("/api/profs")
public class ProfController {

	@Autowired
	private ProfRepository profRepo;

	@Autowired
	@Qualifier("profService")
	private IProfService profService;

	@GetMapping("/allProfs")
	public List<Prof> getAllProf() {
		return profRepo.findAll();
	}

	@GetMapping("/allProfsByNomAndPrenom/{nom}/{prenom}")
	public List<Prof> getAllProfByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
		return profService.retreiveByNomAndPrenom(nom, prenom);
	}

	@GetMapping("/allProfsByNomStartingBy/{prefix}")
	public List<Prof> getAllProfByNomStartsWith(@PathVariable String prefix) {
		return profService.retreiveByNomStartsWith(prefix);
	}

	@GetMapping("/profById/{id}")
	public Prof getProfById(@PathVariable Long id) {
		return profRepo.findById(id).orElse(null);
	}

	@PostMapping("/addProf")
	public Prof saveProf(@RequestBody Prof prof) {
		return profRepo.save(prof);
	}

	@PutMapping("/updateProf/{id}")
	public Prof updateById(@PathVariable Long id, @RequestBody Prof prof) throws Exception {
		return profService.updateProfById(id, prof);
	}

	@DeleteMapping("/deleteProf/{id}")
	public void deleteById(@PathVariable Long id) {
		profService.deleteProfById(id);
	}
}
