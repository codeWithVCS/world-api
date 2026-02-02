package com.world.api.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Simplified country information for list views")
public class CountrySummaryDto {

    @Schema(description = "3-letter ISO country code", example = "IND")
    private String code;

    @Schema(description = "Full name of the country", example = "India")
    private String name;

    @Schema(description = "Continent where the country is located", example = "Asia")
    private String continent;

    @Schema(description = "Sub-region of the continent", example = "Southern Asia")
    private String region;

    @Schema(description = "Total population of the country", example = "1393409038")
    private Integer population;
}