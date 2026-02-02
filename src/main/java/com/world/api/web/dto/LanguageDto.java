package com.world.api.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Information about a language spoken in a country")
public class LanguageDto {

    @Schema(description = "Name of the language", example = "Hindi")
    private String language;

    @Schema(description = "Whether the language is official in this country", example = "T")
    private String isOfficial;

    @Schema(description = "Percentage of the population speaking this language", example = "41.0")
    private BigDecimal percentage;
}