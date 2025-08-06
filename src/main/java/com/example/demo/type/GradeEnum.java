package com.example.demo.type;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum GradeEnum {

	MAITRE(1, "Maître"), MAITRE_CONFERENCE(2, "Maitre de Conference"), MAITRE_ASSISTANT(3, "Maitre Assistant");

	private final int id;
	private final String label;

	GradeEnum(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public static GradeEnum getGradeFromId(int id) {
		for (GradeEnum g : GradeEnum.values()) {
			if (g.id == id)
				return g;
		}
		throw new IllegalArgumentException("Invalid Grade id: " + id);
	}

	@JsonCreator
	public static GradeEnum fromLabel(String label) {
		for (GradeEnum grade : GradeEnum.values()) {
			if (grade.label.equalsIgnoreCase(label)) {
				return grade;
			}
		}

		throw new IllegalArgumentException("Invalid grade: " + label);
	}
}
