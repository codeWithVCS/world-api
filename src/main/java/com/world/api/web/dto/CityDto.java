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
@Schema(description = "Details of a specific city")
public class CityDto {

    @Schema(description = "Unique identifier of the city", example = "1024")
    private Integer id;

    @Schema(description = "Name of the city", example = "Mumbai")
    private String name;

    @Schema(description = "District or state where the city is located", example = "Maharashtra")
    private String district;

    @Schema(description = "Current population of the city", example = "10500000")
    private Integer population;
}