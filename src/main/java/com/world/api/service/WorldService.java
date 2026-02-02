package com.world.api.service;

import com.world.api.domain.enums.Continent;
import com.world.api.web.dto.CityDto;
import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;
import com.world.api.web.dto.LanguageDto;

import java.util.List;

public interface WorldService {

    List<CountrySummaryDto> getAllCountries();
    CountryResponseDto getCountryByCode(String code);
    List<CountrySummaryDto> searchCountriesByName(String name);
    List<CountrySummaryDto> getCountriesByContinent(Continent continent);

    CityDto getCityById(Integer id);
    List<CityDto> getCitiesByCountry(String countryCode);
    List<CityDto> searchCitiesByName(String name);
    List<CityDto> getTopCitiesByContinent(Continent continent, int limit);

    List<LanguageDto> getLanguagesByCountry(String countryCode);
    List<CountrySummaryDto> getCountriesByLanguage(String language);

}
