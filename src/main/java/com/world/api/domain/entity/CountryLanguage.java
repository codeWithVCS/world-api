package com.world.api.domain.entity;

import com.world.api.domain.enums.IsOfficial;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "countrylanguage")
@Getter @Setter
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("countryCode")
    @JoinColumn(name = "CountryCode", columnDefinition = "char(3)")
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "IsOfficial", nullable = false)
    private IsOfficial isOfficial;

    @Column(name = "Percentage", nullable = false, precision = 4, scale = 1)
    private BigDecimal percentage;
}