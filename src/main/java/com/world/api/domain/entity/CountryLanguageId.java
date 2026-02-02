package com.world.api.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CountryLanguageId implements Serializable {

    @Column(name = "CountryCode", columnDefinition = "char(3)")
    private String countryCode;

    @Column(name = "Language", columnDefinition = "char(30)")
    private String language;
}