package com.world.api.config;

import com.world.api.domain.enums.Continent;
import org.springframework.format.Formatter;
import java.util.Locale;

public class ContinentFormatter implements Formatter<Continent> {

    @Override
    public Continent parse(String text, Locale locale) {
        return Continent.fromValue(text);
    }

    @Override
    public String print(Continent object, Locale locale) {
        return object.getValue();
    }
}