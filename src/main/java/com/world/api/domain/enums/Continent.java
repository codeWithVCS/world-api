package com.world.api.domain.enums;

import lombok.Getter;
import java.util.stream.Stream;

@Getter
public enum Continent {
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private final String value;

    Continent(String value) {
        this.value = value;
    }
    
    public static Continent fromValue(String value) {
        return Stream.of(Continent.values())
                .filter(c -> c.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown continent: " + value));
    }

    @Override
    public String toString() {
        return this.value;
    }
}