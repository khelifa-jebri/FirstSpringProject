package com.example.demo.entities;

import java.util.List;

import com.example.demo.type.GradeEnum;
import com.example.demo.utils.GradeConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Prof extends Person {

	@Column(name = "specialite")
	private String specialite;

	@Column(name = "grade")
	@Convert(converter = GradeConverter.class)
	private GradeEnum grade = GradeEnum.MAITRE_CONFERENCE;

	@ManyToMany
	@JoinTable(name = "prof_classe", joinColumns = @JoinColumn(name = "prof_id"), inverseJoinColumns = @JoinColumn(name = "classe_id"))
	private List<Classe> classesList;

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Classe> getClassesList() {
		return classesList;
	}

	public void setClassesList(List<Classe> classesList) {
		this.classesList = classesList;
	}

	public GradeEnum getGrade() {
		return grade;
	}

	public void setGrade(GradeEnum grade) {
		this.grade = grade;
	}

}
