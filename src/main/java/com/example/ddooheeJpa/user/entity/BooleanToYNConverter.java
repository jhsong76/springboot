package com.example.ddooheeJpa.user.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return (value != null && value) ? "재학생" : "졸업생";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "재학생".equals(value);
    }
}
