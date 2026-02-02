package com.world.api.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "city")
@Getter @Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", nullable = false, columnDefinition = "char(35)")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode", nullable = false, columnDefinition = "char(3)")
    private Country country;

    @Column(name = "District", nullable = false, columnDefinition = "char(20)")
    private String district;

    @Column(name = "Population", nullable = false)
    private Integer population;
}