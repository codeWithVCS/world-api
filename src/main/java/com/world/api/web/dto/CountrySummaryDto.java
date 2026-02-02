package com.world.api.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountrySummaryDto {

    private String code;
    private String name;
    private String continent;
    private String region;
    private Integer population;

}
