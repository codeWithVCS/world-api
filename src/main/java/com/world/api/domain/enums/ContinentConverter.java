package com.world.api.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Continent, String> {

    @Override
    public String convertToDatabaseColumn(Continent continent) {
        return continent == null ? null : continent.getValue();
    }

    @Override
    public Continent convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Continent.fromValue(dbData);
    }
}