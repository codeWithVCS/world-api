package com.world.api.service.impl;

import com.world.api.domain.entity.City;
import com.world.api.domain.entity.Country;
import com.world.api.domain.entity.CountryLanguage;
import com.world.api.domain.enums.Continent;
import com.world.api.exception.ResourceNotFoundException;
import com.world.api.repository.CityRepository;
import com.world.api.repository.CountryLanguageRepository;
import com.world.api.repository.CountryRepository;
import com.world.api.service.WorldService;
import com.world.api.web.dto.CityDto;
import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;
import com.world.api.web.dto.LanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorldServiceImpl implements WorldService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final CountryLanguageRepository languageRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CountrySummaryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(this::mapToCountrySummary)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CountryResponseDto getCountryByCode(String code) {
        Country country = countryRepository.findByCodeWithDetails(code)
                .orElseThrow(() -> new ResourceNotFoundException("Country with code " + code + " not found"));

        return new CountryResponseDto(
                country.getCode(),
                country.getName(),
                country.getContinent().toString(),
                country.getRegion(),
                country.getSurfaceArea(),
                country.getIndepYear(),
                country.getPopulation(),
                country.getLifeExpectancy(),
                country.getGnp(),
                country.getGnpOld(),
                country.getLocalName(),
                country.getGovernmentForm(),
                country.getHeadOfState(),
                country.getCapital(),
                country.getCode2(),
                country.getCities().stream().map(this::mapToCityDto).collect(Collectors.toList()),
                country.getLanguages().stream().map(this::mapToLanguageDto).collect(Collectors.toList())
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountrySummaryDto> searchCountriesByName(String name) {
        if (name == null || name.trim().isEmpty()) return List.of();

        return countryRepository.findByNameContainingIgnoreCase(name.trim()).stream()
                .map(this::mapToCountrySummary)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountrySummaryDto> getCountriesByContinent(Continent continent) {
        return countryRepository.findByContinent(continent).stream()
                .map(this::mapToCountrySummary)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CityDto getCityById(Integer id) {
        return cityRepository.findById(id)
                .map(this::mapToCityDto)
                .orElseThrow(() -> new ResourceNotFoundException("City with ID " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> getCitiesByCountry(String countryCode) {
        if (!countryRepository.existsById(countryCode)) {
            throw new ResourceNotFoundException("Country with code " + countryCode + " not found");
        }
        return cityRepository.findByCountryCode(countryCode).stream()
                .map(this::mapToCityDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> searchCitiesByName(String name) {
        if (name == null || name.trim().isEmpty()) return List.of();

        return cityRepository.findByNameContainingIgnoreCase(name.trim()).stream()
                .map(this::mapToCityDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> getTopCitiesByContinent(Continent continent, int limit) {
        return cityRepository.findTopCitiesByContinent(continent, PageRequest.of(0, limit)).stream()
                .map(this::mapToCityDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LanguageDto> getLanguagesByCountry(String countryCode) {
        if (!countryRepository.existsById(countryCode)) {
            throw new ResourceNotFoundException("Country with code " + countryCode + " not found");
        }
        return languageRepository.findByIdCountryCode(countryCode).stream()
                .map(this::mapToLanguageDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CountrySummaryDto> getCountriesByLanguage(String language) {
        if (language == null || language.trim().isEmpty()) return List.of();

        return languageRepository.findCountriesByLanguage(language.trim()).stream()
                .map(this::mapToCountrySummary)
                .collect(Collectors.toList());
    }

    private CountrySummaryDto mapToCountrySummary(Country country) {
        return new CountrySummaryDto(
                country.getCode(),
                country.getName(),
                country.getContinent().toString(),
                country.getRegion(),
                country.getPopulation()
        );
    }

    private CityDto mapToCityDto(City city) {
        return new CityDto(
                city.getId(),
                city.getName(),
                city.getDistrict(),
                city.getPopulation()
        );
    }

    private LanguageDto mapToLanguageDto(CountryLanguage lang) {
        return new LanguageDto(
                lang.getId().getLanguage(),
                lang.getIsOfficial().toString(),
                lang.getPercentage()
        );
    }
}