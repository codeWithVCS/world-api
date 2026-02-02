package com.world.api.domain.entity;

import com.world.api.domain.enums.Continent;
import com.world.api.domain.enums.ContinentConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "country")
@Getter @Setter
public class Country {
    @Id
    @Column(name = "Code", columnDefinition = "char(3)")
    private String code;

    @Column(name = "Name", nullable = false, columnDefinition = "char(52)")
    private String name;

    @Convert(converter = ContinentConverter.class)
    @Column(name = "Continent", nullable = false, columnDefinition = "enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')")
    private Continent continent;

    @Column(name = "Region", nullable = false, columnDefinition = "char(26)")
    private String region;

    @Column(name = "SurfaceArea", nullable = false, precision = 10, scale = 2)
    private BigDecimal surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(name = "Population", nullable = false)
    private Integer population;

    @Column(name = "LifeExpectancy", precision = 3, scale = 1)
    private BigDecimal lifeExpectancy;

    @Column(name = "GNP", precision = 10, scale = 2)
    private BigDecimal gnp;

    @Column(name = "GNPOld", precision = 10, scale = 2)
    private BigDecimal gnpOld;

    @Column(name = "LocalName", nullable = false, columnDefinition = "char(45)")
    private String localName;

    @Column(name = "GovernmentForm", nullable = false, columnDefinition = "char(45)")
    private String governmentForm;

    @Column(name = "HeadOfState", columnDefinition = "char(60)")
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", nullable = false, columnDefinition = "char(2)")
    private String code2;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    @OneToMany(mappedBy = "country")
    private List<CountryLanguage> languages;
}