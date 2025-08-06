package com.example.demo.utils;

import com.example.demo.type.GradeEnum;

import jakarta.persistence.AttributeConverter;

public class GradeConverter implements AttributeConverter<GradeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(GradeEnum attribute) {
		return (attribute == null) ? null : attribute.getId();
	}

	@Override
	public GradeEnum convertToEntityAttribute(Integer dbData) {
		return (dbData == null) ? null : GradeEnum.getGradeFromId(dbData);
	}
}
