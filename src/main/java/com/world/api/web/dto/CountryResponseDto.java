package com.world.api.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Full details of a country including its cities and languages")
public class CountryResponseDto {

    @Schema(description = "3-letter ISO country code", example = "USA")
    private String code;

    @Schema(description = "Full name of the country", example = "United States")
    private String name;

    @Schema(description = "Continent of the country", example = "North America")
    private String continent;

    @Schema(description = "Geographical region", example = "North America")
    private String region;

    @Schema(description = "Total surface area in square kilometers", example = "9363520.00")
    private BigDecimal surfaceArea;

    @Schema(description = "Year of independence", example = "1776")
    private Short indepYear;

    @Schema(description = "Total population", example = "328239523")
    private Integer population;

    @Schema(description = "Average life expectancy", example = "78.9")
    private BigDecimal lifeExpectancy;

    @Schema(description = "Gross National Product", example = "8510700.00")
    private BigDecimal gnp;

    @Schema(description = "Previous Gross National Product", example = "8110900.00")
    private BigDecimal gnpOld;

    @Schema(description = "Local name of the country", example = "United States")
    private String localName;

    @Schema(description = "Type of government", example = "Federal Republic")
    private String governmentForm;

    @Schema(description = "Current head of state", example = "Joe Biden")
    private String headOfState;

    @Schema(description = "ID of the capital city", example = "3813")
    private Integer capital;

    @Schema(description = "2-letter ISO country code", example = "US")
    private String code2;

    @Schema(description = "List of major cities in the country")
    private List<CityDto> cities;

    @Schema(description = "List of languages spoken in the country")
    private List<LanguageDto> languages;
}