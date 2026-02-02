package com.world.api.service;

import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;

import java.util.List;

public interface WorldService {

    List<CountrySummaryDto> getAllCountries();

    CountryResponseDto getCountryByCode(String code);

}
