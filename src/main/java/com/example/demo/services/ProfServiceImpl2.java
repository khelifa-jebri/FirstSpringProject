package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Prof;

@Service("profService2")
public class ProfServiceImpl2 implements IProfService {

	@Override
	public List<Prof> retreiveByNomAndPrenom(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prof> retreiveByNomStartsWith(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prof updateProfById(Long id, Prof profDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProfById(Long id) {
		// TODO Auto-generated method stub
		
	}


}
