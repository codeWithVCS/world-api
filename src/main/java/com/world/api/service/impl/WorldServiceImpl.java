package com.world.api.service.impl;

import com.world.api.domain.entity.City;
import com.world.api.domain.entity.Country;
import com.world.api.domain.entity.CountryLanguage;
import com.world.api.exception.ResourceNotFoundException;
import com.world.api.repository.CountryRepository;
import com.world.api.service.WorldService;
import com.world.api.web.dto.CityDto;
import com.world.api.web.dto.CountryResponseDto;
import com.world.api.web.dto.CountrySummaryDto;
import com.world.api.web.dto.LanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorldServiceImpl implements WorldService {

    private final CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CountrySummaryDto> getAllCountries() {
        List<Country> countryList = countryRepository.findAll();
        List<CountrySummaryDto> responses = new ArrayList<>();
        for (Country country : countryList) {
            responses.add(new CountrySummaryDto(
                  country.getCode(),
                  country.getName(),
                  country.getContinent().toString(),
                  country.getRegion(),
                  country.getPopulation()
            ));
        }
        return responses;
    }

    @Override
    @Transactional(readOnly = true)
    public CountryResponseDto getCountryByCode(String code) {
        Country country = countryRepository.findByCodeWithDetails(code)
                .orElseThrow(() -> new ResourceNotFoundException("Country with code " + code + " not found"));
        List<City> cities = country.getCities();
        List<CountryLanguage> languages = country.getLanguages();
        List<CityDto> cityDtos = new ArrayList<>();
        List<LanguageDto> languageDtos = new ArrayList<>();
        for (City city : cities) {
            cityDtos.add(new CityDto(
                    city.getId(),
                    city.getName(),
                    city.getDistrict(),
                    city.getPopulation()
            ));
        }
        for(CountryLanguage countryLanguage : languages) {
            languageDtos.add(new LanguageDto(
                    countryLanguage.getId().getLanguage(),
                    countryLanguage.getIsOfficial().toString(),
                    countryLanguage.getPercentage()
            ));
        }
        CountryResponseDto responseDto = new CountryResponseDto(
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
                cityDtos,
                languageDtos
        );
        return  responseDto;
    }
}
