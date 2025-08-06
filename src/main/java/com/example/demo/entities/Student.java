package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student extends Person {

	@Column(name = "numInscription")
	private Long numInscription;

	@ManyToOne
	@JoinColumn(name = "classe_id")
	private Classe classe;
	
	public Long getNumInscription() {
		return numInscription;
	}

	public void setNumInscription(Long numInscription) {
		this.numInscription = numInscription;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
}
